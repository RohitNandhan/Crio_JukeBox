package com.crio.old.jukebox.entites;

import java.util.List;
import java.util.Optional;

public class PlayPlaylist {
    private User user;
    private Playlist playlist;
    private Song currentSong;

    public PlayPlaylist(User user, Playlist playlist) {
        this.user = user;
        this.playlist = playlist;
        // this.song = song;
    }

    public String getUserId() {
        return user.getId();
    }

    public String getPlaylistId() {
        return playlist.getId();
    }
    public Song getCurrentSong(){
        return playlist.getSongs().get(0);
    }
    public Song getSongById(String songId) {
     Optional<Song> temp= playlist.getSongs().stream().filter(song -> songId.equals(song.getId())).findFirst();
        return temp.get();
    }
    public List<Song> getSongList(){
        return playlist.getSongs();
    }

}
