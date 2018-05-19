package com.example.toshiba_97.installretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toshiba_97.installretrofit.Generator.ServiceGenerator;
import com.example.toshiba_97.installretrofit.Model.ChuckNorisQuote;
import com.example.toshiba_97.installretrofit.Services.ChuckService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ChuckService chuckService;
    Button btnReload;
    TextView txtData;
    ImageView imgChuck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReload = (Button) findViewById(R.id.btnReload);
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reloadData();
            }
        });
    }

    private void reloadData() {
        chuckService = ServiceGenerator.createService(ChuckService.class);
        txtData = (TextView) findViewById(R.id.txtData);
        imgChuck = (ImageView) findViewById(R.id.imgChuck);
        Call<ChuckNorisQuote> call = chuckService.getQuote();
        call.enqueue(new Callback<ChuckNorisQuote>() {
            @Override
            public void onResponse(Call<ChuckNorisQuote> call,
                                   Response<ChuckNorisQuote> response) {
                txtData.setText(response.body().getValue());
                Picasso.with(getApplicationContext()).load(response.body().getIconUrl()).
                        into(imgChuck);
            }

            @Override
            public void onFailure(Call<ChuckNorisQuote> call, Throwable
                    t) {
                txtData.setText(t.getMessage());
            }
        });
    }
}
