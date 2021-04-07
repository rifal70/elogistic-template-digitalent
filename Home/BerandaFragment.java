package com.example.elogisticmaritime.Activity.Fragment;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.elogisticmaritime.Activity.Activity.DetailNoPesananActivity;
import com.example.elogisticmaritime.Activity.Activity.JadwalKapalActivity;
import com.example.elogisticmaritime.Activity.Adapter.JadwalAdapter;
import com.example.elogisticmaritime.Activity.Adapter.ListPelabuhanAdapter;
import com.example.elogisticmaritime.Activity.Adapter.PartnerAdapter;
import com.example.elogisticmaritime.Activity.Adapter.SemuaJadwalAdapter;
import com.example.elogisticmaritime.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.mancj.slideup.SlideUp;
import com.mancj.slideup.SlideUpBuilder;

import java.util.Objects;

public class BerandaFragment extends Fragment implements View.OnClickListener {
    TabLayout tabLayout;
    TextInputEditText etPelabuhanAwal, etPelabuhanTujuan;
    RecyclerView rvPartner, rvSeringDicari, rvPencarianLainnya;
    AppBarLayout appBarLayout;
    Button btnLihatSemuaJadwal, btnCekTarifPengiriman, btnCariPesanan;
    int tabPosition = 0;
    Dialog dialogCekTarif;
    Intent variableintent;

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

        rvPartner = view.findViewById(R.id.rv_partner);
        appBarLayout = view.findViewById(R.id.abl_beranda);
        tabLayout = view.findViewById(R.id.tl_jadwal_kontainer);
        btnLihatSemuaJadwal = view.findViewById(R.id.btn_lihat_semua_jadwal);
        etPelabuhanAwal = view.findViewById(R.id.et_pelabuhan_awal);
        etPelabuhanTujuan = view.findViewById(R.id.et_pelabuhan_tujuan);
        btnCekTarifPengiriman = view.findViewById(R.id.btn_cek_tarif_pengiriman);
        dialogCekTarif = new Dialog(getContext());
        btnCariPesanan = view.findViewById(R.id.btn_cari_pesanan);

        fragmentJadwal(tabPosition);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPartner.setLayoutManager(layoutManager);
        rvPartner.setItemAnimator(new DefaultItemAnimator());

        PartnerAdapter partnerAdapter = new PartnerAdapter(getContext());
        rvPartner.setAdapter(partnerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPosition = tab.getPosition();
                fragmentJadwal(tabPosition);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        etPelabuhanAwal.setOnClickListener(this);
        etPelabuhanTujuan.setOnClickListener(this);
        btnLihatSemuaJadwal.setOnClickListener(this);
        btnCekTarifPengiriman.setOnClickListener(this);
        btnCariPesanan.setOnClickListener(this);

    }

    public void fragmentJadwal(int tab) {
        Fragment fragment = new TabJadwalFragment(tab);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_jadwal_kontainer, fragment);
        fragmentTransaction.commit();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.et_pelabuhan_awal:
            case R.id.et_pelabuhan_tujuan:
                bottomSheet();
                break;
            case R.id.btn_cek_tarif_pengiriman:
                Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                cekTarifPengirimanDialog();
                break;
            case R.id.btn_lihat_semua_jadwal:
                variableintent = new Intent(getActivity(), JadwalKapalActivity.class);
                variableintent.putExtra("tab", tabPosition);
                startActivity(variableintent);
                break;
            case R.id.btn_cari_pesanan:
                variableintent = new Intent(getActivity(), DetailNoPesananActivity.class);
                startActivity(variableintent);
                break;
        }
    }

    public void bottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getActivity(), R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getContext())
                .inflate(R.layout.slide_up_list_pelabuhan,
                        (NestedScrollView)getView().findViewById(R.id.nsv_slideup));
        bottomSheetView.findViewById(R.id.btn_batal).setOnClickListener(v1 -> {
            bottomSheetDialog.dismiss();
        });
        rvSeringDicari = bottomSheetView.findViewById(R.id.rv_sering_dicari);
        rvPencarianLainnya = bottomSheetView.findViewById(R.id.rv_pencarian_lainnya);
        rvSeringDicari.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPencarianLainnya.setLayoutManager(new LinearLayoutManager(getContext()));

        bottomSheetDialog.setContentView(bottomSheetView);

        bottomSheetDialog.show();
        ListPelabuhanAdapter listPelabuhanAdapter = new ListPelabuhanAdapter(getContext());
        rvPencarianLainnya.setAdapter(listPelabuhanAdapter);
        rvSeringDicari.setAdapter(listPelabuhanAdapter);
    }

    public void cekTarifPengirimanDialog(){
        dialogCekTarif.setContentView(R.layout.confirmation_dialog);
        ImageView ivClose = dialogCekTarif.findViewById(R.id.iv_close_dialog);
        Button btnKembali = dialogCekTarif.findViewById(R.id.btn_kembali);
        ivClose.setOnClickListener(v->{
            dialogCekTarif.dismiss();
        });
        btnKembali.setOnClickListener(v->{
            dialogCekTarif.dismiss();
        });
        dialogCekTarif.show();
    }

}