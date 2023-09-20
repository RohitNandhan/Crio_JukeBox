package com.crio.jukebox.dto;

import java.util.List;

public class PlayListUpdateResponse {
    private String playlistId;
    private String playlistName;
    private List<String> songids;

    public PlayListUpdateResponse(String playlistId, String playlistName, List<String> songids) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songids = songids;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<String> getSongids() {
        return songids;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist ID - ").append(playlistId).append("\n");
        sb.append("Playlist Name - ").append(playlistName).append("\n");
        sb.append("Song IDs - ");
        for (String songId : songids) {
            sb.append(songId).append(" ");
        }
        return sb.toString().trim();
    }

}
