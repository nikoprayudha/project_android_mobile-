package com.putraprima.ppmsqliteexamplefirst;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.putraprima.ppmsqliteexamplefirst.models.Penulis;

public class TambahPenulis extends AppCompatActivity {

    EditText txtNamaPenulis,txtUmur;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    Button btnSimpanPenulis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penulis);

        Button btnSimpanPenulis = (Button) findViewById(R.id.btnSimpanPenulis);
        RadioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        txtUmur = (EditText) findViewById(R.id.txtUmur);
        txtNamaPenulis = (EditText) findViewById(R.id.txtNamaPenulis);
        txtNamaPenulis.requestFocus();
        btnSimpanPenulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                Penulis mPenulis = new Penulis(txtNamaPenulis.getText().toString(),radioButton.getText().toString(),txtUmur.getText().toString());
                mPenulis.save();
                txtUmur.setText("");
                txtNamaPenulis.setText("");
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.constraintLayout),
                        "Data Berhasil Disimpan", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });
    }
}
