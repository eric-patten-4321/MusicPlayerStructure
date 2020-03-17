package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicplayer.data.Song;

import java.util.ArrayList;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_detail);

        //get references to views
        TextView title = findViewById(R.id.detail_artist_name);
        TextView artist = findViewById(R.id.detail_song_title);
        ImageButton prevButton = findViewById(R.id.prevButton);
        ImageButton pauseButton = findViewById(R.id.pauseButton);
        ImageButton playButton = findViewById(R.id.playButton);
        ImageButton nextButton = findViewById(R.id.nextButton);
        ImageButton searchButton = findViewById(R.id.imgBtn_search);
        ImageView albumArt = findViewById(R.id.imgView_albumArt);

        //get intent from SongListAdapter containing the clicked song
        Intent i = getIntent();
        final Song song = (Song) i.getSerializableExtra("sentSong");
        // get serialized array songlist
        final ArrayList<Song> songList = (ArrayList<Song>) i.getSerializableExtra("songList");


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
                // put serialized array songList into intent to pass list to next activity
                i.putExtra("songList", songList);
                startActivity(i);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playPreviousSong();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // playNextSong();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlaying.this, "Now playing: " + song.getSongTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlaying.this, "Playback paused", Toast.LENGTH_SHORT).show();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NowPlaying.this, SearchActivity.class);
                i.putExtra("songList", songList);
                startActivity(i);
            }
        });
    }
}

