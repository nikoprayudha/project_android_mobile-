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

import com.example.toshiba_97.uts_profile.Models.Pendidikan;


public class DetailPendidikan extends AppCompatActivity {
    TextView namaPendidikan,tingkatPendidikan,tahunLulus;
    EditText updatenamaPendidikan, updatetingkatPendidikan, updatetahunLulus;
    Long id;
    private Button buttonUpdate;
    private Button buttonDeletePendidikan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pendidikan);

        //        menampilkan data
        Intent i = getIntent();
        Long idPendidikan = i.getLongExtra("pendidikanId",0L);
        final Pendidikan detailPendidikan = Pendidikan.findById(Pendidikan.class,idPendidikan);

        namaPendidikan = (TextView) findViewById(R.id.namaPendidikan);
        namaPendidikan.setText(detailPendidikan.getNamapendidikan());
        tingkatPendidikan = (TextView) findViewById(R.id.tingkatPendidikan);
        tingkatPendidikan.setText(detailPendidikan.getTingkatpendidikan());
        tahunLulus = (TextView) findViewById(R.id.tahunLulus);
        tahunLulus.setText(Integer.toString(detailPendidikan.getTahunlulus()));
        namaPendidikan.requestFocus();

//update
        buttonUpdate = (Button) findViewById(R.id.btnUpdatePendidikan);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatenamaPendidikan = (EditText) findViewById(R.id.namaPendidikan);
                updatetingkatPendidikan = (EditText) findViewById(R.id.tingkatPendidikan);
                updatetahunLulus = (EditText) findViewById(R.id.tahunLulus);

                Intent i = getIntent();
                Long idPend = i.getLongExtra("pendidikanId",0L);
                Pendidikan updatePend = Pendidikan.findById(Pendidikan.class,idPend);
                updatePend.namapendidikan= updatenamaPendidikan.getText().toString();
                updatePend.tingkatpendidikan= updatetingkatPendidikan.getText().toString();
                updatePend.tahunlulus=Integer.parseInt(updatetahunLulus.getText().toString());
                updatePend.save();
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Data Berhasil Di Rubah", Snackbar.LENGTH_LONG);
                snackbar.show();
//                Intent e = new Intent(getApplicationContext(),DaftarPendidikan.class);
//                startActivity(e);

            }
        });
//delete
        buttonDeletePendidikan = (Button) findViewById(R.id.btnDeletePendidikan);
        buttonDeletePendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),detailPendidikan.getId().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DaftarProfile.class);
                i.putExtra("penidikanId",detailPendidikan.getId());
                Long idPend = i.getLongExtra("penidikanId",0L);
                Pendidikan deletePen = Pendidikan.findById(Pendidikan.class,idPend);
                deletePen.delete();
                startActivity(i);
            }
        });
    }
}
