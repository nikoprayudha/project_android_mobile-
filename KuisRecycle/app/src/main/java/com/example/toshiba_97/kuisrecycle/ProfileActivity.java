package com.example.toshiba_97.kuisrecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button next = (Button) findViewById(R.id.ButtonPendidikan);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PendidikanActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button prev = (Button) findViewById(R.id.ButtonKeluarga);
        prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), KeluargaaActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

    }
}
