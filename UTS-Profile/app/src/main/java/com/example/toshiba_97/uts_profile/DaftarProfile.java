package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.toshiba_97.uts_profile.Adapter.ProfileAdapter;
import com.example.toshiba_97.uts_profile.Models.Profile;

import java.util.ArrayList;
import java.util.List;

public class DaftarProfile extends AppCompatActivity {
    private  Button btnTambah;
    private ProfileAdapter mAdapters;
    private List<Profile> mDaftarProfile = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_profile);

        mDaftarProfile = Profile.listAll(Profile.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerProfile);
        mAdapters = new ProfileAdapter(getApplicationContext(),mDaftarProfile);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapters);
        mAdapters.notifyDataSetChanged();

//      Tambah
        btnTambah = (Button) findViewById(R.id.btnTambahProfile);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahProfile.class);
                startActivity(i);
            }
        });
    }
}
