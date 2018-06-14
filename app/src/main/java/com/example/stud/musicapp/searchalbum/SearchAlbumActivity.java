package com.example.stud.musicapp.searchalbum;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stud.musicapp.API.Apiservice;
import com.example.stud.musicapp.API.SearchAlbum;
import com.example.stud.musicapp.API.SearchAlbums;
import com.example.stud.musicapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAlbumActivity extends AppCompatActivity {

    EditText etQuery;
    RecyclerView rvList;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_album);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        etQuery = findViewById(R.id.edQuery);
        rvList=findViewById(R.id.rvList);

        try {
            etQuery .setText( sharedPreferences .getString( "query" , null ));
        } catch (ClassCastException e) {
            Log.e ( "TAG" , "błąd odczytu danych" , e);
        }

        Button bSearch = findViewById(R.id.bSearch);
        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query=etQuery.getText().toString();
                rememberQuery(query);
                serchAlbums(query);
            }
        });
    }

    private void rememberQuery(String query){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString( "query" , query);
        editor.apply();
    }

    private void serchAlbums(String query) {
        getSupportActionBar().setSubtitle(query);
        if (query == null || query.isEmpty()) {
            Toast.makeText(this, "Pusta fraza", Toast.LENGTH_SHORT).show();
            return;
        }
        Call<SearchAlbums> searchAlbumCall = Apiservice.getService().searchAlbums("query");
        searchAlbumCall.enqueue(new Callback<SearchAlbums>() {
            @Override
            public void onResponse(Call<SearchAlbums> call, Response<SearchAlbums> response) {
                SearchAlbums searchAlbums = response.body();
                if (searchAlbums == null || searchAlbums. album == null ||
                        searchAlbums. album .isEmpty()) {
                    Toast. makeText (SearchAlbumActivity. this , "Brak wyników" ,
                            Toast. LENGTH_SHORT ).show();
                    return ;
                }
                Toast. makeText (SearchAlbumActivity. this , "Znaleziono " +
                        searchAlbums. album .size() + " wyników" , Toast. LENGTH_SHORT ).show();

            }

            @Override
            public void onFailure(Call<SearchAlbums> call, Throwable t) {
                Toast. makeText (SearchAlbumActivity. this , "Błąd pobierania danych: " +
                        t.getLocalizedMessage(), Toast. LENGTH_SHORT ).show();
            }
        });
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
