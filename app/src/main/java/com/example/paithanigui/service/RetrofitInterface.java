package com.example.paithanigui.service;



import com.example.paithanigui.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("product.php")
    abstract public Call<Example> getProducts();

}