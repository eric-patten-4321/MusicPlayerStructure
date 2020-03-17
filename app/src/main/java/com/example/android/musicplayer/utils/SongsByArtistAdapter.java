package com.example.android.musicplayer.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.data.Song;

import java.util.ArrayList;

public class SongsByArtistAdapter extends ArrayAdapter<Song>{

    public SongsByArtistAdapter(@NonNull Context context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    // TODO: 3/15/20 make activity_songs_by_artist and artist_view pretty 

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View nowPlayingView = convertView;
        if (nowPlayingView == null) {
            nowPlayingView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_view_item, parent, false);
        }
        Song currentSong = getItem(position);
        TextView songName = nowPlayingView.findViewById(R.id.tv_songByArtist);

        if (currentSong != null) {
            songName.setText(currentSong.getSongTitle());
        }

        return nowPlayingView;
    }
}

