package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Model.TheLoai;
import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtheloaitheochudeAdapter extends RecyclerView.Adapter<DanhsachtheloaitheochudeAdapter.DanhsachtheloaitheochudeViewHolder>{
    Context context;
    ArrayList<TheLoai> theLoaiArrayList;

    public DanhsachtheloaitheochudeAdapter(Context context, ArrayList<TheLoai> theLoaiArrayList) {
        this.context = context;
        this.theLoaiArrayList = theLoaiArrayList;
    }

    @NonNull
    @Override
    public DanhsachtheloaitheochudeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_the_loai_theo_chu_de, parent, false);
        return new DanhsachtheloaitheochudeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhsachtheloaitheochudeViewHolder holder, int position) {
        TheLoai theLoai = theLoaiArrayList.get(position);
        Picasso.with(context).load(theLoai.getHinhTheLoai()).into(holder.imghinhnen);
        holder.txttentheloai.setText(theLoai.getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        return theLoaiArrayList.size();
    }

    public class DanhsachtheloaitheochudeViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen;
        TextView txttentheloai;
        public DanhsachtheloaitheochudeViewHolder(View itemView){
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewtheloaitheochude);
            txttentheloai = itemView.findViewById(R.id.textviewtentheloaitheochude);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("idtheloai",theLoaiArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
