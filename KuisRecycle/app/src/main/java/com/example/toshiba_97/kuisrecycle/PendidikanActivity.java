package com.example.toshiba_97.kuisrecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PendidikanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RiwayatPendidikanAdapter mAdapter;
    private List<RiwayatPendidikan> riwayatList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);

        recyclerView = (RecyclerView) findViewById(R.id.listPendidikan);

        mAdapter = new RiwayatPendidikanAdapter(riwayatList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        hasilRiwayatData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent a = new Intent(getApplicationContext(),DetailPendidikanActivity.class);
                RiwayatPendidikan r = riwayatList.get(position);
                a.putExtra("Nama",r.getNamaSekolah());
                a.putExtra("Tahun",Integer.toString(r.getTahun()));
                a.putExtra("Alamat",r.getAlamat());
                 startActivity(a);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void hasilRiwayatData() {
        RiwayatPendidikan riwayat = new RiwayatPendidikan(2003, "TK DHARMA WANITA", "Jl.Sarimun, Beji, Kota Batu");
        riwayatList.add(riwayat);
        riwayat = new RiwayatPendidikan(2009, "SDN BEJI 01", "Jl.Sarimun, Beji, Kota Batu");
        riwayatList.add(riwayat);
        riwayat = new RiwayatPendidikan(2012, "MTS Negeri Batu", "Jl.Areng-Areng, Dadaprejo, Kota Batu ");
        riwayatList.add(riwayat);
        riwayat = new RiwayatPendidikan(2015, "SMK PGRI 3 MALANG", "Jl.Tlogomas, Tlogomas, Kota Malang");
        riwayatList.add(riwayat);
        riwayat = new RiwayatPendidikan(2019, "Politeknik Negeri Malang", "Jl.Soekarno Hatta No9,Kota Malang");
        riwayatList.add(riwayat);

        mAdapter.notifyDataSetChanged();
    }
}
