package com.example.stud.musicapp.searchalbum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stud.musicapp.R;

public class SearchAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_album);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true ;
    }
}
