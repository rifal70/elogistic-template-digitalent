package com.example.elogisticmaritime.Activity.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elogisticmaritime.Activity.Adapter.BerangkatAdapter;
import com.example.elogisticmaritime.R;

public class FragmentTabBerangkat extends Fragment {
    RecyclerView rvTabBerangkat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_berangkat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTabBerangkat = view.findViewById(R.id.rv_tab_berangkat);
        rvTabBerangkat.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        rvTabBerangkat.addItemDecoration(itemDecoration);

        BerangkatAdapter berangkatAdapter = new BerangkatAdapter(getContext());
        rvTabBerangkat.setAdapter(berangkatAdapter);
    }
}