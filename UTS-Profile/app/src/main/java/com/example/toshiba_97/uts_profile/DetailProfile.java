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

import com.example.toshiba_97.uts_profile.Models.Profile;

public class DetailProfile extends AppCompatActivity {
    TextView namaProfile,tglLahir,alamat;
    EditText updateProfile, updateTgl, updateAlamat;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    Long id;

    private Button buttonUpdate;
    private Button buttonDeleteProfile;
    private Button btnTambahPendidikan;
    private Button btnTambahKeluarga;
    private Button btnTambahKegiatan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profile);

        //menampilkan data
        Intent i = getIntent();
        id = i.getLongExtra("profileId",0L);
        final Profile detailProfile = Profile.findById(Profile.class,id);

        namaProfile = (TextView) findViewById(R.id.namaProfile);
        namaProfile.setText(detailProfile.getNama());
        tglLahir = (TextView) findViewById(R.id.tglLahir);
        tglLahir.setText(detailProfile.getTgllahir());
        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        String jk=detailProfile.getJk();
        if (jk.equalsIgnoreCase("Laki-laki")==true){
            RadioButton l = (RadioButton) findViewById(R.id.Laki);
            l.setChecked(true);
        }
        else if(jk.equalsIgnoreCase("Perempuan")==true){
            RadioButton p = (RadioButton) findViewById(R.id.Perempuan);
            p.setChecked(true);
        }
        alamat = (TextView) findViewById(R.id.alamat);
        alamat.setText(detailProfile.getAlamat());
        namaProfile.requestFocus();

//update
        buttonUpdate = (Button) findViewById(R.id.btnUpdateProfile);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile = (EditText) findViewById(R.id.namaProfile);
                updateTgl = (EditText) findViewById(R.id.tglLahir);
                updateAlamat = (EditText) findViewById(R.id.alamat);
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                Intent i = getIntent();
                Long idProf = i.getLongExtra("profileId",0L);
                Profile updatePro = Profile.findById(Profile.class,idProf);
                updatePro.nama= updateProfile.getText().toString();
                updatePro.alamat= updateAlamat.getText().toString();
                updatePro.tgllahir= updateTgl.getText().toString();
                updatePro.jk= radioButton.getText().toString();
                updatePro.save();
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Rubah", Snackbar.LENGTH_LONG);
                snackbar.show();
                Intent e = new Intent(getApplicationContext(),DaftarProfile.class);
                startActivity(e);

            }
        });

        btnTambahPendidikan = (Button) findViewById(R.id.btnPendidikan);
        btnTambahPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DaftarPendidikan.class);
                i.putExtra("profileId", id);
                startActivityForResult(i, 0);
            }
        });

        buttonDeleteProfile = (Button) findViewById(R.id.btnDeleteProfile);
        buttonDeleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),detailProfile.getId().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DaftarProfile.class);
                i.putExtra("profileId",detailProfile.getId());
                Long idPro = i.getLongExtra("profileId",0L);
                Profile deletePro = Profile.findById(Profile.class,idPro);
                deletePro.delete();
                startActivity(i);
            }
        });


        btnTambahKeluarga = (Button) findViewById(R.id.btnKeluarga);
        btnTambahKeluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DaftarKeluarga.class);
                i.putExtra("profileId", id);
                startActivityForResult(i, 0);
            }
        });

        btnTambahKegiatan = (Button) findViewById(R.id.btnKegiatan);
        btnTambahKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DaftarKegiatan.class);
                i.putExtra("profileId", id);
                startActivityForResult(i, 0);
            }
        });
    }
}
