//package com.example.appnhac.Adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.text.Layout;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.example.appnhac.Activity.DanhsachbaihatActivity;
//import com.example.appnhac.Model.Quangcao;
//import com.example.appnhac.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class BannerAdapter1 extends PagerAdapter {
//    Context context;
//    ArrayList<Quangcao> arrayListbanner;
//
//    public BannerAdapter1(Context context, ArrayList<Quangcao> arrayListbanner) {
//        this.arrayListbanner = arrayListbanner;
//    }
//
//    @Override
//    public int getCount() {
//        return arrayListbanner.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.dong_banner, container, false);
//
//        ImageView imgbackgroundbanner = view.findViewById(R.id.imgviewbackgroundbanner);
//        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
//        TextView txttitlesongbannner = view.findViewById(R.id.textviewtitlebannerbaihat);
//        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);
//
//        Picasso.with(context).load(arrayListbanner.get(position).getHinhanh()).into(imgbackgroundbanner);
//        Picasso.with(context).load(arrayListbanner.get(position).getHinhBaiHat()).into(imgsongbanner);
//        txttitlesongbannner.setText(arrayListbanner.get(position).getTenBaiHat());
//        txtnoidung.setText(arrayListbanner.get(position).getNoidung());
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
//                intent.putExtra("banner",arrayListbanner.get(position));
//                context.startActivity(intent);
//            }
//        });
//        return view;
//    }
//}