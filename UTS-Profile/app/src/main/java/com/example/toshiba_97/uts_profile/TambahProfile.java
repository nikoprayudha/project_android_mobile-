package com.example.toshiba_97.uts_profile;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.toshiba_97.uts_profile.Models.Profile;

public class TambahProfile extends AppCompatActivity {

    EditText txtNamaProfile,txtTglLahir,txtAlamat;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    Button btnSimpanProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_profile);

//        TextBox T = (TextBox)sender;
//        try{
//            char[]UnallowwedCharacters = {
//                    '0','1','2','3','4','5','6','7','8','9'
//            }
//
//        }
        final Button btnSimpanProfile = (Button) findViewById(R.id.btnSimpanProfile);

        txtNamaProfile = (EditText) findViewById(R.id.txtNamaProfile);
        txtTglLahir = (EditText) findViewById(R.id.txtTglLahir);
        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        txtAlamat = (EditText) findViewById(R.id.txtAlamat);
        txtNamaProfile.requestFocus();

        btnSimpanProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNamaProfile.getText().toString().trim().length()==0 || txtTglLahir.getText().toString().trim().length()==0 || radioButton.getText().length()==0 ||
                txtAlamat.getText().toString().trim().length()==0 )  {
                    Toast.makeText(TambahProfile.this,"Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    Profile mProfile = new Profile(txtNamaProfile.getText().toString(),txtTglLahir.getText().toString(),radioButton.getText().toString(),txtAlamat.getText().toString());
                    mProfile.save();
                    txtAlamat.setText("");
                    txtTglLahir.setText("");
                    txtNamaProfile.setText("");
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Simpan", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    Intent e = new Intent(getApplicationContext(), DaftarProfile.class);
                    startActivity(e);
                }

            }
        });
    }
}
