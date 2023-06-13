package com.example.appnhac.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.PlayNhacAcitvity;
import com.example.appnhac.Adapter.PlaynhacAdapter;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.R;

public class Fragment_Play_Danh_Sach_Cac_Bai_Hat extends Fragment {

    View view;
    RecyclerView recyclerViewplaynhac;
    PlaynhacAdapter playnhacAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bai_hat, container, false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewPlaybaihat);

        if (PlayNhacAcitvity.mangbaihat.size() > 0) {
            playnhacAdapter = new PlaynhacAdapter(getActivity(), PlayNhacAcitvity.mangbaihat);

            // Set item click listener on the playnhacAdapter
            playnhacAdapter.setOnItemClickListener(new PlaynhacAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    // Play the selected song
                    playSong(position);
                }
            });

            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playnhacAdapter);
        }

        return view;
    }

    private void playSong(int position) {
        // Retrieve the selected song from the mangbaihat ArrayList using the position
        Baihat selectedSong = PlayNhacAcitvity.mangbaihat.get(position);

        // Perform the necessary actions to play the selected song
        // For example, you can pass the selected song to the MediaPlayer or start a new Activity/Fragment to play the song
        // You can also notify the activity/fragment hosting the adapter about the selected song using a callback interface
        // Implement the necessary logic based on your application's requirements
    }
}
