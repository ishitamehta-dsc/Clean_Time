package com.example.cleantime.apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://34.106.247.159/";

    public static Retrofit getRetrofitInstance(){

        if (retrofit == null){
            Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retrofit;
    }

}
