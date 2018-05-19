package com.example.toshiba_97.installretrofit.Services;

import com.example.toshiba_97.installretrofit.Model.ChuckNorisQuote;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by TOSHIBA-97 on 11/21/2017.
 */

public interface ChuckService {
    @GET("jokes/random")
    Call<ChuckNorisQuote> getQuote();
}
