package com.crio.old.jukebox.entites;

import java.util.List;

public class SongD extends BaseEntity {
    private String songName;
    private Album album;
    private List<Artists> artists;

    public SongD(String id, String songName, Album album, List<Artists> artists) {
        super(id);
        this.songName = songName;
        this.album = album;
        this.artists = artists;
    }

    public String getSongName() {
        return songName;
    }

    public Album getAlbum() {
        return album;
    }

    public List<Artists> getArtists() {
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
