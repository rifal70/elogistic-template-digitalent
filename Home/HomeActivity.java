package com.example.elogisticmaritime.Activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.elogisticmaritime.Activity.Fragment.BerandaFragment;
import com.example.elogisticmaritime.Activity.Fragment.OrderFragment;
import com.example.elogisticmaritime.Activity.Fragment.RiwayatFragment;
import com.example.elogisticmaritime.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationMenu;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationMenu = findViewById(R.id.bottom_navigation);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(this);

        Fragment fragment = new BerandaFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_area, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_beranda:
                fragment = new BerandaFragment();
                fragmentManager =getSupportFragmentManager();
                fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.screen_area, fragment);
                fragmentTransaction.commit();
                break;
            case R.id.menu_order:
                fragment = new OrderFragment();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.screen_area, fragment);
                fragmentTransaction.commit();
                break;
            case R.id.menu_history:
                fragment = new RiwayatFragment();
                fragmentManager =getSupportFragmentManager();
                fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.screen_area, fragment);
                fragmentTransaction.commit();
                break;
            case R.id.menu_profile:
                break;
        }
        return true;
    }

    public void fragmentTrans(Fragment fragment){
        fragmentManager =getSupportFragmentManager();
        fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_area, fragment);
        fragmentTransaction.commit();
    }
}