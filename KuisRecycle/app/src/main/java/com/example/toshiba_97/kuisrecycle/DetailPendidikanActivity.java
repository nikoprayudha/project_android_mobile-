package com.example.toshiba_97.kuisrecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailPendidikanActivity extends AppCompatActivity {
    private TextView namaSekolah,Tahun,Alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pendidikan);

        namaSekolah = (TextView) findViewById(R.id.Nama);
        Tahun = (TextView) findViewById(R.id.TahunSklh);
        Alamat = (TextView) findViewById(R.id.Alamat);
        Intent r = getIntent();

        String b = r.getStringExtra("Nama");
        String c = r.getStringExtra("Tahun");
        String d = r.getStringExtra("Alamat");

        namaSekolah.setText(b);
        Tahun.setText(c);
        Alamat.setText(d);

    }
}
