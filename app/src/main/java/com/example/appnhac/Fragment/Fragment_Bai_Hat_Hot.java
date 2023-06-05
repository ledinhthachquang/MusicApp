package com.example.appnhac.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Adapter.BaihathotAdapter;
import com.example.appnhac.Model.SongWithHeart;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Bai_Hat_Hot extends Fragment {
    View view;
    RecyclerView recyclerViewBaihathot;
    BaihathotAdapter baihathotAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bai_hat_hot,container,false);
        GetData();
        recyclerViewBaihathot = view.findViewById(R.id.recyclerviewBaihathot);
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<SongWithHeart>> callback = dataservice.GetBaiHatHot();
        callback.enqueue(new Callback<List<SongWithHeart>>() {
            @Override
            public void onResponse(Call<List<SongWithHeart>> call, Response<List<SongWithHeart>> response) {
                ArrayList<SongWithHeart> baihatArrayList = (ArrayList<SongWithHeart>) response.body();
                baihathotAdapter = new BaihathotAdapter(getActivity(),baihatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewBaihathot.setLayoutManager(linearLayoutManager);
                recyclerViewBaihathot.setAdapter(baihathotAdapter);
            }

            @Override
            public void onFailure(Call<List<SongWithHeart>> call, Throwable t) {

            }
        });
    }
}
