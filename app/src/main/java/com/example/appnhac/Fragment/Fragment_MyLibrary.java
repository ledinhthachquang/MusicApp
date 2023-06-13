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

import com.example.appnhac.Adapter.LibraryAdapter;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_MyLibrary extends Fragment {

    private List<Baihat> libraryList;
    private RecyclerView libraryRecyclerView;
    private LibraryAdapter libraryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_library, container, false);

        libraryRecyclerView = view.findViewById(R.id.libraryRecyclerView);
        libraryRecyclerView.setHasFixedSize(true);
        libraryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize library list and adapter
        libraryList = new ArrayList<>();
        libraryAdapter = new LibraryAdapter(getContext(), libraryList);
        libraryRecyclerView.setAdapter(libraryAdapter);

        // TODO: Load and populate libraryList with data

        return view;
    }
}
