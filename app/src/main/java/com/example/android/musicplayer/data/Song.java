package com.example.android.musicplayer.data;

import java.io.Serializable;

public class Song implements Serializable {
    private String mSongTitle;
    private String mArtistName;
    private String mAlbumName;

    public Song(String songTitle, String artistName, String albumName) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumName = albumName;
    }

    public Song(String songTitle, String artistName) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumName = "unknown";
    }

    public String getSongTitle() {
        return this.mSongTitle;
    }
    public String getArtistName() {
        return this.mArtistName;
    }
    public String getAlbumName() {
        return this.mAlbumName;
    }

    public void setSongTitle(String songTitle) {
        this.mSongTitle = songTitle;
    }

    public void setArtistName(String artistName) {
        this.mArtistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.mAlbumName = albumName;
    }


}
