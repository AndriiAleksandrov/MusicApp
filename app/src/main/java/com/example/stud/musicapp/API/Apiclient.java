package com.example.stud.musicapp.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiclient {

    @GET( "trending.php" )
    Call<TrendingList> getTrendingList(@Query ( "country" ) String country, @Query ( "type" )
            String type, @Query( "format" ) String format);
}