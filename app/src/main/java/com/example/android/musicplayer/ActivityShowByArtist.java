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
    private ArrayList<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_by_artist);

        // get artist name and song name from click in NowPlaying
        // get the whole songlist array from intent
        Intent i = getIntent();
        artistsName = i.getSerializableExtra("artistName").toString();
        songList = (ArrayList<Song>) i.getSerializableExtra("songList");
        //initialize array to put other songs by artist into.
        ArrayList<Song> artistsList = new ArrayList<>();
        TextView artistHeader = findViewById(R.id.tv_artistsHeader);

        //add songs from songList into artistList to display only songs by nowPlaying artist.
        if (!songList.isEmpty()){
            for (int index = 0; index < songList.size(); index++) {
                if (songList.get(index).getArtistName().equals(artistsName)) {
                    artistsList.add(songList.get(index));
                }
            }
        }


        // get and display artists name at top of screen
        artistHeader.setText(artistsName);

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
                // put songList in to pass the whole array to next activity
                i.putExtra("songList", songList);
                startActivity(i);
            }
        });
    }
}
