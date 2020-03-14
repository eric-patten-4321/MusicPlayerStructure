package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicplayer.data.Song;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_detail);

        //get references to views
        TextView title = findViewById(R.id.detail_artist_name);
        TextView artist = findViewById(R.id.detail_song_title);

        //get intent from SongListAdapter containing the clicked song
        Intent i = getIntent();
        final Song song = (Song) i.getSerializableExtra("sentSong");
        
        //get title, etc from song and display in views
        //// TODO: 3/11/20 implement null checks
        title.setText(song.getSongTitle());
        artist.setText(song.getArtistName());
        
        // pass artist name in intent and search through a copy of the array thats in showbyartist - gotta be a better way...
        // TODO: 3/12/20 find a better way.... 
        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NowPlaying.this, ActivityShowByArtist.class);
                i.putExtra("artistName", song.getArtistName());
                startActivity(i);
            }
        });
    }
}
