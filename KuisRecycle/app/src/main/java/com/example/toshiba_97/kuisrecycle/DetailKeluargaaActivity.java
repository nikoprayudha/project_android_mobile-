package com.example.toshiba_97.kuisrecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKeluargaaActivity extends AppCompatActivity {
    private TextView status,nama,tahunlahir,pekerjaan;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_keluargaa);

        nama = (TextView) findViewById(R.id.namakeluargaa);
        status = (TextView) findViewById(R.id.statuss);
        tahunlahir = (TextView) findViewById(R.id.tahuun);
        pekerjaan = (TextView) findViewById(R.id.pekerjaan);
        foto = (ImageView) findViewById(R.id.foto);

        Intent r = getIntent();
        String b = r.getStringExtra("nama");
        String c = r.getStringExtra("status");
        String d = r.getStringExtra("tahun");
        String e = r.getStringExtra("pekerjaan");
        int f = r.getIntExtra("foto",0);

        nama.setText(b);
        status.setText(c);
        tahunlahir.setText(d);
        pekerjaan.setText(e);
        foto.setImageResource(f);
    }
}
