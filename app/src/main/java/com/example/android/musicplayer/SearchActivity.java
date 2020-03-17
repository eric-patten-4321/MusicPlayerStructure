package com.example.android.musicplayer;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_search);

        // get references to views
        EditText searchBySong = findViewById(R.id.et_searchSong);
        EditText searchByArtist = findViewById(R.id.et_searchArtist);
        EditText searchByAlbum = findViewById(R.id.et_searchAlbum);
        ImageButton btnSearchSong = findViewById(R.id.btn_searchSong);
        ImageButton btnSearchArtist = findViewById(R.id.btn_searchArtist);
        ImageButton btnSearchAlbum = findViewById(R.id.btn_searchAlbum);



    }

}


