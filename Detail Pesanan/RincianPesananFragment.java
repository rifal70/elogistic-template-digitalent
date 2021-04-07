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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elogisticmaritime.R;

public class RincianPesananFragment extends Fragment {
    ImageView ivBack;
    TextView tvLihatInfoPengiriman;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rincian_pesanan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivBack = view.findViewById(R.id.iv_back);
        tvLihatInfoPengiriman = view.findViewById(R.id.tv_lihat_info_pengiriman);

        tvLihatInfoPengiriman.setOnClickListener(v->{
            Fragment fragment = new TrackingFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fl_detail, fragment);
            fragmentTransaction.commit();
        });

        ivBack.setOnClickListener(v->{
            getActivity().finish();
        });
    }
}