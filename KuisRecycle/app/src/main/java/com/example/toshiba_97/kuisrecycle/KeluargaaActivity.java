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

public class KeluargaaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataKeluargaAdapter mAdapter;
    private List<DataKeluarga> riwayatlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluargaa);

        recyclerView = (RecyclerView) findViewById(R.id.listKeluarga);

        mAdapter = new DataKeluargaAdapter(riwayatlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent a = new Intent(getApplicationContext(), DetailKeluargaaActivity.class);
                DataKeluarga r = riwayatlist.get(position);
                a.putExtra("nama", r.getNama());
                a.putExtra("status", r.getStatus());
                a.putExtra("tahun",Integer.toString(r.getTahunlahir()));
                a.putExtra("foto",r.getImage());
                a.putExtra("pekerjaan",r.getPekerjaan());
                startActivity(a);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        hasildatakeluarga();
    }

    private void hasildatakeluarga(){
        DataKeluarga riwayat = new DataKeluarga(1973, "Buari", "Ayah", "STAF PROCESSING", R.drawable.n);
        riwayatlist.add(riwayat);
        riwayat = new DataKeluarga(1979, "Sutiani", "Ibu", "Ibu Rumah Tangga", R.drawable.n);
        riwayatlist.add(riwayat);
        mAdapter.notifyDataSetChanged();
    }
}
