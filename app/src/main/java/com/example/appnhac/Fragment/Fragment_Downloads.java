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

import com.example.appnhac.Adapter.DownloadAdapter;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Downloads extends Fragment {

    private List<Baihat> downloadList;
    private RecyclerView downloadsRecyclerView;
    private DownloadAdapter downloadAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_downloads, container, false);

        downloadsRecyclerView = view.findViewById(R.id.downloadsRecyclerView);
        downloadsRecyclerView.setHasFixedSize(true);
        downloadsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize download list and adapter
        downloadList = new ArrayList<>();
        downloadAdapter = new DownloadAdapter(getContext(), downloadList);
        downloadsRecyclerView.setAdapter(downloadAdapter);

        // TODO: Load and populate downloadList with data

        return view;
    }
}
