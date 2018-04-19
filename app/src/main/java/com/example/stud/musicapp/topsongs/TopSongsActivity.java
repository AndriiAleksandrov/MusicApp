package com.example.stud.musicapp.topsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.stud.musicapp.API.Apiservice;
import com.example.stud.musicapp.API.TrendingList;
import com.example.stud.musicapp.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Call<TrendingList> trendingListCall = Apiservice.getService().getTrendingList("us","itunes","singles");
        trendingListCall.enqueue(new Callback<TrendingList>() {
            @Override
            public void onResponse(Call<TrendingList> call, Response<TrendingList> response) {
                TrendingList trendingList = response.body();

                Toast.makeText(TopSongsActivity.this,"elemtow: "+trendingList.trending.size(), Toast. LENGTH_SHORT ).show();
                Log.d ( "TAG" , new Gson().toJson(trendingList));

            }

            @Override
            public void onFailure(Call<TrendingList> call, Throwable t) {

                Toast.makeText(TopSongsActivity.this,"blad pobierania danych"+t.getLocalizedMessage(), Toast. LENGTH_SHORT ).show();

            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true ;
    }
}
