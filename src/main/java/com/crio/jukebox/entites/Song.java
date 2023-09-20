package com.crio.jukebox.entites;

import java.util.List;

public class Song extends BaseEntity {
    private String songName;
    private String genre;
    private String album;
    private String albumArtist;
    private List<String> artists;

    public Song(String id, String songName, String genre,String album,String albumArtist, List<String> artists) {
        super(id);
        this.songName = songName;
        this.genre=genre;
        this.album = album;
        this.artists = artists;
        this.albumArtist=albumArtist;
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

    public String getAlbumArtist() {
        return albumArtist;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songName + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + album + '\'' +
                ", albumArtist='" + albumArtist + '\'' +
                ", artists=" + artists +
                ", id='" + id + '\'' +
                '}';
    }
}

