package com.example.appnhac.Fragment;

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


public class Fragment_ChuDeVaTheLoai extends Fragment {



    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthemchudevatheloai;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chu_de_va_the_loai,container,false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollview);
        txtxemthemchudevatheloai = view.findViewById(R.id.textviewviewmorechude);
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
                for(int i = 0;i<(theLoaiArrayList.size());i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(theLoaiArrayList.get(i).getHinhTheLoai() != null){
                        Picasso.with(getActivity()).load(theLoaiArrayList.get(i).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
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