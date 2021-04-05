package com.example.elogisticmaritime.Activity.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.elogisticmaritime.R;

public class RiwayatFragment extends Fragment {
    LinearLayout llWaiting, llProcess, llSending, llArrived;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        llWaiting = view.findViewById(R.id.ll_riwayat_waiting);
        llProcess = view.findViewById(R.id.ll_riwayat_process);
        llSending = view.findViewById(R.id.ll_riwayat_sending);
        llArrived = view.findViewById(R.id.ll_riwayat_arrived);

        Fragment fragment = new RiwayatItemFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_riwayat, fragment);
        fragmentTransaction.commit();
    }

}