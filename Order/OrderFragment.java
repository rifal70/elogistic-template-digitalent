package com.example.elogisticmaritime.Activity.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.elogisticmaritime.R;


public class OrderFragment extends Fragment {
    Button btnPersonal, btnKolaborasi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPersonal = view.findViewById(R.id.btn_personal);
        btnKolaborasi = view.findViewById(R.id.btn_kolaborasi);

        btnPersonal.setPressed(true);

        btnPersonal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btnPersonal.setPressed(true);
                btnKolaborasi.setPressed(false);
                return true;
            }
        });

        btnKolaborasi.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btnKolaborasi.setPressed(true);
                btnPersonal.setPressed(false);
                return true;
            }
        });


    }
}