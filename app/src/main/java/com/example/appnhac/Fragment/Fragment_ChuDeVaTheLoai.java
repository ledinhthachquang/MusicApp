package com.example.appnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Activity.DanhsachtatcachudeActivity;
import com.example.appnhac.Model.ChuDe;
import com.example.appnhac.Model.ChuDeVaTheLoai;
import com.example.appnhac.Model.TheLoai;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class    Fragment_ChuDeVaTheLoai extends Fragment {



    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthemchudetheloai;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chu_de_va_the_loai,container,false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollview);
        txtxemthemchudetheloai = view.findViewById(R.id.textviewviewmorechude);
        txtxemthemchudetheloai.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), DanhsachtatcachudeActivity.class);
                startActivity(intent);
            }
        });
        getData();
        return view;
    }
    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<ChuDeVaTheLoai> callback = dataservice.GetDataChuDeVaTheLoai();
        callback.enqueue(new Callback<ChuDeVaTheLoai>() {
            @Override
            public void onResponse(Call<ChuDeVaTheLoai> call, Response<ChuDeVaTheLoai> response) {
                ChuDeVaTheLoai chuDeVaTheLoai = response.body();
                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(chuDeVaTheLoai.getChuDe());
                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(chuDeVaTheLoai.getTheLoai());
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);

                layout.setMargins(10,20,10,30);
                for(int i = 0;i<(chuDeArrayList.size());i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(chuDeArrayList.get(i).getHinhChuDe() != null){
                        Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for(int j = 0;j<(theLoaiArrayList.size());j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(theLoaiArrayList.get(j).getHinhTheLoai() != null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    final int finalJ = j;
                    imageView.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                            intent.putExtra("idtheloai", theLoaiArrayList.get(finalJ));
                            startActivity(intent);
                        }
                    });
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<ChuDeVaTheLoai> call, Throwable t) {
                Log.d("chudevatheloai",t.getMessage());

            }
        });
    }
}