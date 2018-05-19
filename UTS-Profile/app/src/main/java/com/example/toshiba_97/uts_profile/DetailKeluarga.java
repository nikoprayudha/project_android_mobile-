package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.Models.Keluarga;
import com.example.toshiba_97.uts_profile.Models.Pendidikan;
import com.example.toshiba_97.uts_profile.Models.Profile;

public class DetailKeluarga extends AppCompatActivity {
    TextView namaKeluarga,tingkatPendidikan,tahunLahir,Umur;
    EditText updateKeluarga, updateTingkat, updateTahun,updateUmur;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    Long id;

    private Button buttonUpdate;
    private Button buttonDeleteKeluarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_keluarga);

        //menampilkan data
        Intent i = getIntent();
        id = i.getLongExtra("keluargaId",0L);
        final Keluarga detailKeluarga = Keluarga.findById(Keluarga.class,id);

        namaKeluarga = (TextView) findViewById(R.id.namaKeluarga);
        namaKeluarga.setText(detailKeluarga.getNamakeluarga());
        tingkatPendidikan = (TextView) findViewById(R.id.tingkatPendidikan);
        tingkatPendidikan.setText(detailKeluarga.getTingkatpendidikan());
        tahunLahir = (TextView) findViewById(R.id.tahunLahir);
        tahunLahir.setText(Integer.toString(detailKeluarga.getTahunlahir()));
        Umur = (TextView) findViewById(R.id.Umur);
        Umur.setText(Integer.toString(detailKeluarga.getUmur()));
        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        String status=detailKeluarga.getStatus();
        if (status.equalsIgnoreCase("Ayah")==true){
            RadioButton l = (RadioButton) findViewById(R.id.Ayah);
            l.setChecked(true);
        }
        else if(status.equalsIgnoreCase("Ibu")==true){
            RadioButton p = (RadioButton) findViewById(R.id.Ibu);
            p.setChecked(true);
        }
        namaKeluarga.requestFocus();

//update
        buttonUpdate = (Button) findViewById(R.id.btnUpdateKeluarga);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateKeluarga = (EditText) findViewById(R.id.namaKeluarga);
                updateTingkat = (EditText) findViewById(R.id.tingkatPendidikan);
                updateTahun = (EditText) findViewById(R.id.tahunLahir);
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                updateUmur = (EditText) findViewById(R.id.Umur);

                Intent i = getIntent();
                Long idKel = i.getLongExtra("keluargaId",0L);
                Keluarga updateKel = Keluarga.findById(Keluarga.class,idKel);
                updateKel.namakeluarga= updateKeluarga.getText().toString();
                updateKel.status= radioButton.getText().toString();
                updateKel.tingkatpendidikan= updateTingkat.getText().toString();
                updateKel.tahunlahir = Integer.parseInt(updateTahun.getText().toString());
                updateKel.umur= Integer.parseInt(updateUmur.getText().toString());

                updateKel.save();
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Rubah", Snackbar.LENGTH_LONG);
                snackbar.show();
//                Intent e = new Intent(getApplicationContext(),DaftarKeluarga.class);
//                startActivity(e);

            }
        });

        //delete
        buttonDeleteKeluarga = (Button) findViewById(R.id.btnDeleteKeluarga);
        buttonDeleteKeluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),detailKeluarga.getId().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DaftarProfile.class);
                i.putExtra("ProfileId",detailKeluarga.getId());
                Long idKel = i.getLongExtra("ProfileId",0L);
                Keluarga deleteKel = Keluarga.findById(Keluarga.class,idKel);
                deleteKel.delete();
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Hapus", Snackbar.LENGTH_LONG);
                snackbar.show();
                startActivity(i);
            }
        });
    }
}
