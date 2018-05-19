package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.Models.Keluarga;
import com.example.toshiba_97.uts_profile.Models.Profile;


public class TambahKeluarga extends AppCompatActivity {

    EditText txtNamaKeluarga,txtTingkatPendidikan,txtTahunLahir,txtUmur;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    Button btnSimpanKeluarga;
    Long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_keluarga);

        Toast.makeText(getApplicationContext(),"ID "+id, Toast.LENGTH_LONG).show();
        Button btnSimpanKeluarga = (Button) findViewById(R.id.btnSimpanKeluarga);
        txtNamaKeluarga = (EditText) findViewById(R.id.txtNamaKeluarga);
        txtTingkatPendidikan = (EditText) findViewById(R.id.txtTingkatPendidikan);
        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        txtTahunLahir = (EditText) findViewById(R.id.txtTahunLahir);
        txtUmur = (EditText) findViewById(R.id.txtUmur);
        txtNamaKeluarga.requestFocus();

        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);

        btnSimpanKeluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                Profile s= new Profile();
                s.setId(id);
                Keluarga mKeluarga = new Keluarga(txtNamaKeluarga.getText().toString(),radioButton.getText().toString(),
                        txtTingkatPendidikan.getText().toString(),Integer.parseInt(txtTahunLahir.getText().toString()),
                        Integer.parseInt(txtUmur.getText().toString()), s);
                mKeluarga.save();

                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Simpan", Snackbar.LENGTH_LONG);
                snackbar.show();
                Intent e = new Intent(getApplicationContext(), DaftarKeluarga.class);
                e.putExtra("profileId", id);
                startActivity(e);
                String idP = Long.toString(id);
                Toast.makeText(getApplicationContext(),idP,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
