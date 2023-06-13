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

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.ViewHolder> {

    private Context context;
    private List<Baihat> downloadList;

    public DownloadAdapter(Context context, List<Baihat> downloadList) {
        this.context = context;
        this.downloadList = downloadList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_download, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = downloadList.get(position);
        holder.txtTenBaiHat.setText(baihat.getTenbaihat());
        holder.txtCaSi.setText(baihat.getCasi());

        // Load image using Picasso library
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imgHinhBaiHat);
    }

    @Override
    public int getItemCount() {
        return downloadList.size();
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
