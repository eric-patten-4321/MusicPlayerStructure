package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicplayer.data.Song;
import com.example.android.musicplayer.utils.SongsByArtistAdapter;

import java.util.ArrayList;

public class ActivityShowByArtist extends AppCompatActivity {

    private String artistsName;
    private ArrayList<Song> allSongs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_by_artist);

        // get artist name and song name from click in NowPlaying
        Intent i = getIntent();
        artistsName = i.getSerializableExtra("artistName").toString();
        //initialize array to put other songs by artist into.
        ArrayList<Song> artistsList = new ArrayList<>();
        TextView artistHeader = findViewById(R.id.tv_artistsHeader);

        // duplicate array of all songs. figure out how to use one array for all activities
        allSongs.add(new Song("Honky Tonk Women", "Rolling Stones"));
        allSongs.add(new Song("Cheap Sunglasses", "ZZTop"));
        allSongs.add(new Song("Franklin's Tower", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Eyes of the World", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Ruben and Cerise", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Standing on the Moon", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Slipknot", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("One More Saturday Night", "Grateful Dead", "Shoreline 06-17-10"));
        allSongs.add(new Song("Reba", "Phish"));
        allSongs.add(new Song("Ester", "Phish"));
        allSongs.add(new Song("You Enjoy Myself", "Phish"));
        allSongs.add(new Song("Wilson", "Phish"));
        allSongs.add(new Song("Picture of Nectar", "Phish", "Picture of Nectar"));

        for (int index = 0; index < allSongs.size(); index++) {
            if (allSongs.get(index).getArtistName().equals(artistsName)) {
                artistsList.add(allSongs.get(index));
            }
        }

        // get and display artists name at top of screen
        artistHeader.setText(artistsList.get(0).getArtistName());

        SongsByArtistAdapter adapter = new SongsByArtistAdapter(this, artistsList);
        final ListView listView = findViewById(R.id.lv_songsByArtist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get clicked song
                Song currentSong = (Song) listView.getItemAtPosition(position);
                // Song is serializable, pack it into the Intent
                Intent i = new Intent(ActivityShowByArtist.this, NowPlaying.class);
                i.putExtra("sentSong", currentSong);
                startActivity(i);
            }
        });
    }
}
