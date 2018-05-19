package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.Models.Kegiatan;


public class DetailKegiatan extends AppCompatActivity {
    TextView namaKegiatan,tglKegiatan,Jam,Lokasi;
    EditText updatenamaKegiatan, updatetglKegiatan, updateJam,updateLokasi;
    Long id;
    private Button buttonUpdate;
    private Button buttonDeleteKegiatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kegiatan);
        //        menampilkan data
        Intent i = getIntent();
        Long idKegiatan = i.getLongExtra("kegiatanId",0L);
        final Kegiatan detailKegiatan = Kegiatan.findById(Kegiatan.class,idKegiatan);

        namaKegiatan = (TextView) findViewById(R.id.namaKegiatan);
        namaKegiatan.setText(detailKegiatan.getNamakegiatan());
        tglKegiatan = (TextView) findViewById(R.id.tglKegiatan);
        tglKegiatan.setText(detailKegiatan.getTglkegiatan());
        Jam = (TextView) findViewById(R.id.Jam);
        Jam.setText(detailKegiatan.getJam());
        Lokasi = (TextView) findViewById(R.id.Lokasi);
        Lokasi.setText(detailKegiatan.getLokasi());

        namaKegiatan.requestFocus();

        //update
        buttonUpdate = (Button) findViewById(R.id.btnUpdateKegiatan);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatenamaKegiatan = (EditText) findViewById(R.id.namaKegiatan);
                updatetglKegiatan = (EditText) findViewById(R.id.tglKegiatan);
                updateJam = (EditText) findViewById(R.id.Jam);
                updateLokasi = (EditText) findViewById(R.id.Lokasi);

                Intent i = getIntent();
                Long idKeg = i.getLongExtra("kegiatanId",0L);
                Kegiatan updateKeg = Kegiatan.findById(Kegiatan.class,idKeg);
                updateKeg.namakegiatan= updatenamaKegiatan.getText().toString();
                updateKeg.tglkegiatan= updatetglKegiatan.getText().toString();
                updateKeg.jam= updateJam.getText().toString();
                updateKeg.lokasi= updateLokasi.getText().toString();

                updateKeg.save();
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Rubah", Snackbar.LENGTH_LONG);
                snackbar.show();
//                Intent e = new Intent(getApplicationContext(),DaftarPendidikan.class);
//                startActivity(e);

            }
        });
//delete
        buttonDeleteKegiatan = (Button) findViewById(R.id.btnDeleteKegiatan);
        buttonDeleteKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),detailKegiatan.getId().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DaftarProfile.class);
                i.putExtra("kegiatanId",detailKegiatan.getId());
                Long idKeg = i.getLongExtra("kegiatanId",0L);
                Kegiatan deleteKeg = Kegiatan.findById(Kegiatan.class,idKeg);
                deleteKeg.delete();
                startActivity(i);
            }
        });
    }
}
