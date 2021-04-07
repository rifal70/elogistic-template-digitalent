package com.example.elogisticmaritime.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.elogisticmaritime.Activity.Fragment.RincianPesananFragment;
import com.example.elogisticmaritime.Activity.Fragment.TabJadwalFragment;
import com.example.elogisticmaritime.R;

public class DetailNoPesananActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_no_pesanan);

        Fragment fragment = new RincianPesananFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_detail, fragment);
        fragmentTransaction.commit();



    }
}