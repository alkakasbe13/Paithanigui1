package com.example.paithanigui.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    public static final String BASE_URL = "http://pherywala.sparsematrix.co.in/sareeapp/sareeapp_accounts/product.php/";
    private static Retrofit retrofit = null;
    //https://sajalnagalkar.000webhostapp.com/
    public static Retrofit getClient() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}