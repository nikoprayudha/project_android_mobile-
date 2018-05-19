package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.toshiba_97.uts_profile.Models.Pendidikan;
import com.example.toshiba_97.uts_profile.Models.Profile;


public class TambahPendidikan extends AppCompatActivity {

    EditText txtNamaPendidikan,txtTingkatPendidikan,txtTahunLulus;
    Button btnSimpanPendidikan;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pendidikan);

        Toast.makeText(getApplicationContext(),"ID "+id, Toast.LENGTH_LONG).show();
        Button btnSimpanPendidikan = (Button) findViewById(R.id.btnSimpanPendidikan);
        txtNamaPendidikan = (EditText) findViewById(R.id.txtNamaPendidikan);
        txtTingkatPendidikan = (EditText) findViewById(R.id.txtTingkatPendidikan);
        txtTahunLulus = (EditText) findViewById(R.id.txtTahunLulus);
        txtNamaPendidikan.requestFocus();

        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);

        btnSimpanPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile s= new Profile();
                s.setId(id);
                Pendidikan mPendidikan = new Pendidikan(txtNamaPendidikan.getText().toString(),txtTingkatPendidikan.getText().toString(),Integer.parseInt(txtTahunLulus.getText().toString()), s);
                mPendidikan.save();
                txtTahunLulus.setText("");
                txtTingkatPendidikan.setText("");
                txtNamaPendidikan.setText("");
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Simpan", Snackbar.LENGTH_LONG);
                snackbar.show();

                Intent e = new Intent(getApplicationContext(), DaftarPendidikan.class);
                e.putExtra("profileId", id);
                startActivity(e);
                String idP = Long.toString(id);
                Toast.makeText(getApplicationContext(),idP,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
