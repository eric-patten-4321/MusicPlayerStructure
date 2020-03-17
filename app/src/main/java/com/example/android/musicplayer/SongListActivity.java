package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicplayer.data.Song;
import com.example.android.musicplayer.utils.SongAdapter;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        final ArrayList<Song> allSongs = new ArrayList<>();

        allSongs.add(new Song("Honky Tonk Women", "Rolling Stones"));
        allSongs.add(new Song("Cheap Sunglasses", "ZZTop"));
        allSongs.add(new Song("Eyes of the World", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Ruben and Cerise", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Standing on the Moon", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Help On The Way", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Franklin's Tower", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Slipknot", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Estimated Prophet", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("One More Saturday Night", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Reba", "Phish"));
        allSongs.add(new Song("Ester", "Phish"));
        allSongs.add(new Song("You Enjoy Myself", "Phish"));
        allSongs.add(new Song("Wilson", "Phish"));
        allSongs.add(new Song("Picture of Nectar", "Phish", "Picture of Nectar"));

        SongAdapter adapter = new SongAdapter(this, allSongs);
        final ListView listView = findViewById(R.id.lv_songsByArtist);
        listView.setAdapter(adapter);

        // click on song in listview to start NowPlayingActivity displaying song that was passed
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get clicked song
                Song currentSong = (Song) listView.getItemAtPosition(position);
                // Song is serializable, pack it into the Intent
                Intent i = new Intent(SongListActivity.this, NowPlaying.class);
                i.putExtra("sentSong", currentSong);
                i.putExtra("songList", allSongs);
                startActivity(i);
            }
        });

    }

}
