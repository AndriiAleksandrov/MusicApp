package com.example.stud.musicapp.API;

import retrofit2.Retrofit;

public class Apiservice {
    public static Apiclient getService(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.theaudiodb.com/api/v1/json/{APIKEY}/")
                .build();
        return retrofit.create(Apiclient.class);
    }

}
