package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView linkToSongs = findViewById(R.id.tv_nowPlaying_title);
        TextView searchStuff = findViewById(R.id.tv_search_link);
//        TextView doTheSearch = findViewById(R.id.tv_do_search);
//        EditText titleToSearch = findViewById(R.id.et_titleSearch);
//        EditText artistSearch = findViewById(R.id.et_artistSearch);
//        EditText albumSearch = findViewById(R.id.et_albumSearch);

        linkToSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongListActivity.class);
                startActivity(intent);
            }
        });

        searchStuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(s);
            }
        });

    }
}

