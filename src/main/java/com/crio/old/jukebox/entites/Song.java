package com.crio.old.jukebox.entites;

import java.util.List;

public class Song extends BaseEntity {
    private String songName;
    private String album;
    private List<String> artists;

    public Song(String id, String songName, String album, List<String> artists) {
        super(id);
        this.songName = songName;
        this.album = album;
        this.artists = artists;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbum() {
        return album;
    }

    public List<String> getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", album=" + album +
                ", artists=" + artists +
                ", id='" + id + '\'' +
                '}';
    }
}
