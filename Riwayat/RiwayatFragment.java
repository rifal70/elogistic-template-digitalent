package com.example.elogisticmaritime.Activity.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.elogisticmaritime.R;

public class RiwayatFragment extends Fragment {
    ImageView ivMenungguPembayaran, ivDiproses, ivDikirim, ivSampaiTujuan;
    ImageView[] cards;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivMenungguPembayaran = view.findViewById(R.id.iv_menunggu_pembayaran);
        ivDiproses = view.findViewById(R.id.iv_diproses);
        ivDikirim = view.findViewById(R.id.iv_dikirim);
        ivSampaiTujuan = view.findViewById(R.id.iv_sampai_tujuan);

        cards = new ImageView[]{ivMenungguPembayaran, ivDiproses, ivDikirim, ivSampaiTujuan};

        ivMenungguPembayaran.setPressed(true);


        ivMenungguPembayaran.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectCard(ivMenungguPembayaran);
                Fragment fragment = new RiwayatMenungguPembayaranFragment();
                fragmentTransaction(fragment);
                return true;
            }
        });
        ivDiproses.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectCard(ivDiproses);
                Fragment fragment = new EmptyStateFragment();
                fragmentTransaction(fragment);
                return true;
            }
        });
        ivDikirim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectCard(ivDikirim);
                Fragment fragment = new EmptyStateFragment();
                fragmentTransaction(fragment);
                return true;
            }
        });
        ivSampaiTujuan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                selectCard(ivSampaiTujuan);
                Fragment fragment = new EmptyStateFragment();
                fragmentTransaction(fragment);
                return true;
            }
        });

        Fragment fragment = new RiwayatMenungguPembayaranFragment();
        fragmentTransaction(fragment);
    }

    public void selectCard(ImageView card){
        card.setPressed(true);
        for (int i=0; i<cards.length; i++){
            if (cards[i]!=card){
                cards[i].setPressed(false);
            }
        }
    }

    public void fragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_riwayat, fragment);
        fragmentTransaction.commit();
    }

}