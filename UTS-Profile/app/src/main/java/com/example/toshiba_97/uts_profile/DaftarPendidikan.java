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

import com.example.toshiba_97.uts_profile.Adapter.PendidikanAdapter;
import com.example.toshiba_97.uts_profile.Models.Pendidikan;

import java.util.ArrayList;
import java.util.List;

public class DaftarPendidikan extends AppCompatActivity {
    private Button btnTambah;
    private PendidikanAdapter mAdapters;
    private List<Pendidikan> mDaftarPendidikan = new ArrayList<>();
    Long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pendidikan);
        setTitle("PENDIDIKAN");

        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);
        String idP = Long.toString(id);
        Toast.makeText(getApplicationContext(),"Daftar Pendidikan "+idP, Toast.LENGTH_LONG).show();
        final List<Pendidikan> mDaftarPendidikan = Pendidikan.findWithQuery(Pendidikan.class, "Select * from PENDIDIKAN where profile = "+idP);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerPendidikan);
        mAdapters = new PendidikanAdapter(getApplicationContext(),mDaftarPendidikan);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapters);
        mAdapters.notifyDataSetChanged();

//link bisa mendapatkan id


        //      Tambah
        btnTambah = (Button) findViewById(R.id.btnTambahPendidikan);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahPendidikan.class);
                i.putExtra("profileId",id);
                startActivity(i);
            }
        });
    }
}
