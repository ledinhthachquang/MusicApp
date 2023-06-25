package com.example.appnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Activity.DanhsachcacplaylistActivity;
import com.example.appnhac.Adapter.PlayListAdapter;
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
    ListView lvplaylist;
    TextView txtviewplaylist, txtviewmoreplaylist;
    PlayListAdapter playListAdapter;
    ArrayList<Playlist> mangplaylist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        lvplaylist = view.findViewById(R.id.listviewplaylist);
        txtviewplaylist = view.findViewById(R.id.textviewplaylist);
        txtviewmoreplaylist = view.findViewById(R.id.textviewviewmoreplaylist);
        getData();
        txtviewmoreplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachcacplaylistActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback =dataservice.GetPlaylist();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
             mangplaylist = (ArrayList<Playlist>) response.body();
             playListAdapter = new PlayListAdapter(getActivity(), android.R.layout.simple_list_item_1,mangplaylist);
             lvplaylist.setAdapter(playListAdapter);
             lvplaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                     Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                     intent.putExtra("itemplaylist",mangplaylist.get(i));
                     startActivity(intent);
                 }
             });
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }
}
