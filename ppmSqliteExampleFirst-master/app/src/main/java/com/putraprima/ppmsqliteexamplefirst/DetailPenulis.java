package com.putraprima.ppmsqliteexamplefirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.putraprima.ppmsqliteexamplefirst.models.Penulis;

public class DetailPenulis extends AppCompatActivity {
    TextView umur,namaPenulis;
    EditText updatePenulis, updateUmur;
    android.widget.RadioGroup RadioGroup;
    RadioButton radioButton;
    private Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penulis);
//        menampilkan data
        Intent i = getIntent();
        Long idPenulis = i.getLongExtra("penulisId",0L);
        Penulis detailPenulis = Penulis.findById(Penulis.class,idPenulis);
        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        namaPenulis = (TextView) findViewById(R.id.namaPenulis);
        namaPenulis.setText(detailPenulis.getNama());
        umur = (TextView) findViewById(R.id.umur);
        umur.setText(detailPenulis.getUmur());
        namaPenulis.requestFocus();

        String jk=detailPenulis.getJk();
        if (jk.equalsIgnoreCase("Laki-laki")==true){
            RadioButton l = (RadioButton) findViewById(R.id.Laki);
            l.setChecked(true);
        }
        else if(jk.equalsIgnoreCase("Perempuan")==true){
            RadioButton p = (RadioButton) findViewById(R.id.Perempuan);
            p.setChecked(true);
        }

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePenulis = (EditText) findViewById(R.id.namaPenulis);
                updateUmur = (EditText) findViewById(R.id.umur);
                int selectedRadioButtonID = RadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedRadioButtonID);
                Intent i = getIntent();
                Long idPenu = i.getLongExtra("penulisId",0L);
                Penulis updatePen = Penulis.findById(Penulis.class,idPenu);
                updatePen.nama= updatePenulis.getText().toString();
                updatePen.umur= updateUmur.getText().toString();
                updatePen.jk= radioButton.getText().toString();
                updatePen.save();
                Intent e = new Intent(getApplicationContext(),DaftarPenulis.class);
                startActivity(e);
            }
        });

    }
}
