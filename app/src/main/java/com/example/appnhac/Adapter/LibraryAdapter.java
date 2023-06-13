package com.example.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Model.Baihat;
import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> {

    private Context context;
    private List<Baihat> libraryList;

    public LibraryAdapter(Context context, List<Baihat> libraryList) {
        this.context = context;
        this.libraryList = libraryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_my_library, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = libraryList.get(position);
        holder.txtTenBaiHat.setText(baihat.getTenbaihat());
        holder.txtCaSi.setText(baihat.getCasi());

        // Load image using Picasso library
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imgHinhBaiHat);
    }

    @Override
    public int getItemCount() {
        return libraryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhBaiHat;
        TextView txtTenBaiHat, txtCaSi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhBaiHat = itemView.findViewById(R.id.imgHinhBaiHat);
            txtTenBaiHat = itemView.findViewById(R.id.txtTenBaiHat);
            txtCaSi = itemView.findViewById(R.id.txtCaSi);
        }
    }
}
