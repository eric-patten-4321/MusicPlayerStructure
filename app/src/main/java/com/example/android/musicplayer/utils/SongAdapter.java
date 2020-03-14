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

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View nowPlayingView = convertView;
        if (nowPlayingView == null) {
            nowPlayingView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_display, parent, false);
        }
        Song currentSong = getItem(position);
        TextView songName = nowPlayingView.findViewById(R.id.tv_nowPlaying_songName);
        TextView artistName = nowPlayingView.findViewById(R.id.tv_nowPlaying_artistName);
        TextView albumName = nowPlayingView.findViewById(R.id.tv_nowPlaying_albumName);

        if (currentSong != null) {
            songName.setText(currentSong.getSongTitle());
            artistName.setText(currentSong.getArtistName());
            albumName.setText(currentSong.getAlbumName());
        }

        return nowPlayingView;
    }
}
