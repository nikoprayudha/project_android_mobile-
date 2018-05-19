package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.Adapter.KeluargaAdapter;
import com.example.toshiba_97.uts_profile.Models.Keluarga;


import java.util.ArrayList;
import java.util.List;

public class DaftarKeluarga extends AppCompatActivity {
    private Button btnTambah;
    private KeluargaAdapter mAdapters;
    private List<Keluarga> mDaftarKeluarga = new ArrayList<>();
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_keluarga);
        setTitle("KELUARGA");

        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);
        String idP = Long.toString(id);
        Toast.makeText(getApplicationContext(),"Daftar Keluarga "+idP, Toast.LENGTH_LONG).show();
        final List<Keluarga> mDaftarKeluarga = Keluarga.findWithQuery(Keluarga.class, "Select * from KELUARGA where profile = "+idP);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerKeluarga);
        mAdapters = new KeluargaAdapter(getApplicationContext(),mDaftarKeluarga);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapters);
        mAdapters.notifyDataSetChanged();


        //      Tambah
        btnTambah = (Button) findViewById(R.id.btnTambahKeluarga);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahKeluarga.class);
                i.putExtra("profileId",id);
                startActivity(i);
            }
        });
    }
}
