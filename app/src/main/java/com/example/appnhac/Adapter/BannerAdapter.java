package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Model.Quangcao;
import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    Context context;
    ArrayList<Quangcao> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dong_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.setBannerData(context, arrayListbanner.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayListbanner.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgbackgroundbanner, imgsongbanner;
        TextView txttitlesongbannner, txtnoidung;

        BannerViewHolder(@NonNull View view) {
            super(view);
            imgbackgroundbanner = view.findViewById(R.id.imgviewbackgroundbanner);
            imgsongbanner = view.findViewById(R.id.imageviewbanner);
            txttitlesongbannner = view.findViewById(R.id.textviewtitlebannerbaihat);
            txtnoidung = view.findViewById(R.id.textviewnoidung);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Quangcao banner = arrayListbanner.get(position);
                        // Launch the DanhsachbaihatActivity with the selected Quangcao
                        Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                        intent.putExtra("banner", banner);
                        context.startActivity(intent);
                    }
                }
            });
        }

        void setBannerData(Context context, Quangcao banner) {
            Picasso.with(context).load(banner.getHinhanh()).into(imgbackgroundbanner);
            Picasso.with(context).load(banner.getHinhBaiHat()).into(imgsongbanner);
            txttitlesongbannner.setText(banner.getTenBaiHat());
            txtnoidung.setText(banner.getNoidung());
        }
    }
}

