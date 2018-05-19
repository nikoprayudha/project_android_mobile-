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

import com.example.toshiba_97.uts_profile.Adapter.KegiatanAdapter;
import com.example.toshiba_97.uts_profile.Adapter.PendidikanAdapter;
import com.example.toshiba_97.uts_profile.Models.Kegiatan;
import com.example.toshiba_97.uts_profile.Models.Pendidikan;

import java.util.ArrayList;
import java.util.List;

public class DaftarKegiatan extends AppCompatActivity {
    private Button btnTambah;
    private KegiatanAdapter mAdapters;
    private List<Kegiatan> mDaftarKegiatan = new ArrayList<>();
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kegiatan);

        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);
        String idP = Long.toString(id);
        Toast.makeText(getApplicationContext(),"Daftar Kegiatan "+idP, Toast.LENGTH_LONG).show();
        final List<Kegiatan> mDaftarKegiatan = Kegiatan.findWithQuery(Kegiatan.class, "Select * from KEGIATAN where profile = "+idP);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerKegiatan);
        mAdapters = new KegiatanAdapter(getApplicationContext(),mDaftarKegiatan);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapters);
        mAdapters.notifyDataSetChanged();

        //      Tambah
        btnTambah = (Button) findViewById(R.id.btnTambahKegiatan);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahKegiatan.class);
                i.putExtra("profileId",id);
                startActivity(i);
            }
        });
    }
}
