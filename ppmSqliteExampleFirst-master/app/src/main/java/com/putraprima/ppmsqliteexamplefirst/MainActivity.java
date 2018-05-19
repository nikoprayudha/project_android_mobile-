package com.putraprima.ppmsqliteexamplefirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.putraprima.ppmsqliteexamplefirst.models.Buku;
import com.putraprima.ppmsqliteexamplefirst.models.Penulis;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnTambah,btnDaftar,btnDeleteAll,btnPenulis,btnDaftarPenulis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahBuku.class);
                startActivity(i);
            }
        });

        btnDaftar = (Button) findViewById(R.id.btnList);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DaftarBuku.class);
                startActivity(i);
            }
        });

        btnDeleteAll = (Button) findViewById(R.id.btnDeleteAll);
        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Buku.deleteAll(Buku.class);
                Penulis.deleteAll(Penulis.class);
            }
        });

//Tambahan Lagi
        btnPenulis = (Button) findViewById(R.id.btnTmbhPenulis);
        btnPenulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahPenulis.class);
                startActivity(i);
            }
        });

        btnDaftarPenulis = (Button) findViewById(R.id.btnListPenulis);
        btnDaftarPenulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DaftarPenulis.class);
                startActivity(i);
            }
        });
    }
}
