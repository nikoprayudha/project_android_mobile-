package com.putraprima.ppmsqliteexamplefirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.putraprima.ppmsqliteexamplefirst.adapter.PenulisAdapter;
import com.putraprima.ppmsqliteexamplefirst.models.Penulis;

import java.util.ArrayList;
import java.util.List;

public class DaftarPenulis extends AppCompatActivity {
    private PenulisAdapter mAdapters;
    private List<Penulis> mDaftarPenulis = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penulis);

        mDaftarPenulis = Penulis.listAll(Penulis.class);

        RecyclerView recyclerPenulis = (RecyclerView) findViewById(R.id.recyclerPenulis);
        mAdapters = new PenulisAdapter(getApplicationContext(),mDaftarPenulis);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPenulis.setLayoutManager(mLayoutManager);
        recyclerPenulis.setItemAnimator(new DefaultItemAnimator());
        recyclerPenulis.setAdapter(mAdapters);
        mAdapters.notifyDataSetChanged();
    }
}
