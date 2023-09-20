package com.crio.jukebox.dto;

//import com.crio.jukebox.entites.Album;
//import com.crio.jukebox.entites.A;
import com.crio.jukebox.entites.Song;

import java.util.List;
import java.util.stream.Collectors;

public class PlayResponse {
    private String songName;
    private String album;
    private List<String> artists;

    public PlayResponse(String song, String album, List<String> artists) {
        this.songName = song;
        this.album = album;
        this.artists = artists;
    }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Current Song Playing\n");
        sb.append("Song - ").append(songName).append("\n");
        sb.append("Album - ").append(album).append("\n");
        sb.append("Artists - ");
//        for (String artist : artists) {
//            sb.append(artist).append(",");}
        String allArtiests=artists.stream().collect(Collectors.joining(","));
        sb.append(allArtiests);
        return sb.toString();
    }
}
