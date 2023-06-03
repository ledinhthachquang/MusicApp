package com.example.appnhac.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appnhac.Model.Playlist;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIRetrofitClient;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Playlist extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        getData();
        return view;
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback =dataservice.GetPlaylist();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangplaylist = (ArrayList<Playlist>) response.body();

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }
}