package com.example.elogisticmaritime.Activity.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elogisticmaritime.Activity.Adapter.RiwayatAdapter;
import com.example.elogisticmaritime.R;

public class RiwayatItemFragment extends Fragment {

    RecyclerView rvRiwayatItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_riwayat_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRiwayatItem = view.findViewById(R.id.rv_riwayat_item);

        rvRiwayatItem.setLayoutManager(new LinearLayoutManager(getContext()));
        RiwayatAdapter adapter = new RiwayatAdapter(getContext());
        rvRiwayatItem.setAdapter(adapter);
    }
}