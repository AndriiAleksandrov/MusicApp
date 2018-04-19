package com.example.stud.musicapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiservice {
    public static Apiclient getService(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.theaudiodb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Apiclient.class);
    }

}
