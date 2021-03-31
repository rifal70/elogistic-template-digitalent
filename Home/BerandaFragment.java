package com.example.elogisticmaritime.Activity.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elogisticmaritime.Activity.Adapter.PartnerAdapter;
import com.example.elogisticmaritime.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.FocusShape;
import me.toptas.fancyshowcase.listener.DismissListener;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

public class BerandaFragment extends Fragment {
    TabLayout tabLayout;
    LinearLayout llToolbar, llTarif, llJadwal;
    FancyShowCaseView showCaseView1, showCaseView2, showCaseView3;
    FancyShowCaseQueue queue;
    RecyclerView rvPartner;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment fragment = new FragmentTabBerangkat();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_jadwal_kontainer, fragment);
        fragmentTransaction.commit();
        tabLayout = view.findViewById(R.id.tl_jadwal_kontainer);

        rvPartner = view.findViewById(R.id.rv_partner);
        appBarLayout = view.findViewById(R.id.abl_beranda);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPartner.setLayoutManager(layoutManager);
        rvPartner.setItemAnimator(new DefaultItemAnimator());

        PartnerAdapter partnerAdapter = new PartnerAdapter(getContext());
        rvPartner.setAdapter(partnerAdapter);
    }
}