package com.example.visualstudio.demomvp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Visual Studio on 10/14/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "https://rotatory-religions.000webhostapp.com/android/";
    private static Retrofit retrofit = null;
    public static Retrofit accAuth() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
