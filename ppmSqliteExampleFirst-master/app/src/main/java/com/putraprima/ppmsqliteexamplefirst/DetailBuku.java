package com.putraprima.ppmsqliteexamplefirst;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.putraprima.ppmsqliteexamplefirst.models.Buku;

public class DetailBuku extends AppCompatActivity {
    TextView judulBuku,isbnBuku,penerbitBuku;
    EditText updateJudul, updateISBN, updatePenerbit;
    private Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);
        Intent i = getIntent();
        Long idBuku = i.getLongExtra("bukuId",0L);
        Buku detailBuku = Buku.findById(Buku.class,idBuku);
        judulBuku = (TextView) findViewById(R.id.judulBuku);
        judulBuku.setText(detailBuku.getJudul());
        isbnBuku = (TextView) findViewById(R.id.isbnBuku);
        isbnBuku.setText(detailBuku.getISBN());
        penerbitBuku = (TextView) findViewById(R.id.penerbitBuku);
        penerbitBuku.setText(detailBuku.getPenerbit());
        judulBuku.requestFocus();

//        Status update
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                menampilkan data
                updateJudul = (EditText) findViewById(R.id.judulBuku);
                updateISBN = (EditText) findViewById(R.id.isbnBuku);
                updatePenerbit = (EditText) findViewById(R.id.penerbitBuku);
//                perintah update
                Intent i = getIntent();
                Long idBuku = i.getLongExtra("bukuId",0L);
                Buku updatebuku = Buku.findById(Buku.class,idBuku);
                updatebuku.judul= updateJudul.getText().toString();
                updatebuku.ISBN= updateISBN.getText().toString();
                updatebuku.penerbit= updatePenerbit.getText().toString();
                updatebuku.save();
//                status popup show dialog
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.constraintLayout),
                        "Data Berhasil DiUpdate", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
//                link ke dihalaman dituju

                Intent e = new Intent(getApplicationContext(),DaftarBuku.class);
                startActivity(e);
            }
        });
    }
}
