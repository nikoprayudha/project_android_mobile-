package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.Models.Kegiatan;
import com.example.toshiba_97.uts_profile.Models.Pendidikan;
import com.example.toshiba_97.uts_profile.Models.Profile;

public class TambahKegiatan extends AppCompatActivity {
    EditText txtNamaKegiatan,txtTglKegiatan,txtJam,txtLokasi;
    Button btnSimpanKegiatan;
    Long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kegiatan);

        Toast.makeText(getApplicationContext(),"ID "+id, Toast.LENGTH_LONG).show();
        Button btnSimpanKegiatan = (Button) findViewById(R.id.btnSimpanKegiatan);
        txtNamaKegiatan = (EditText) findViewById(R.id.txtNamaKegiatan);
        txtTglKegiatan = (EditText) findViewById(R.id.txtTglKegiatan);
        txtJam = (EditText) findViewById(R.id.txtJam);
        txtLokasi = (EditText) findViewById(R.id.txtLokasi);
        txtNamaKegiatan.requestFocus();

        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);

        btnSimpanKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile s= new Profile();
                s.setId(id);
                Kegiatan mKegiatan = new Kegiatan(txtNamaKegiatan.getText().toString(),txtTglKegiatan.getText().toString(),txtJam.getText().toString(),txtLokasi.getText().toString(), s);
                mKegiatan.save();
                txtNamaKegiatan.setText("");
                txtTglKegiatan.setText("");
                txtJam.setText("");
                txtLokasi.setText("");


                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Simpan", Snackbar.LENGTH_LONG);
                snackbar.show();

                Intent e = new Intent(getApplicationContext(), DaftarKegiatan.class);
                e.putExtra("profileId", id);
                startActivity(e);
                String idP = Long.toString(id);
                Toast.makeText(getApplicationContext(),idP,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
