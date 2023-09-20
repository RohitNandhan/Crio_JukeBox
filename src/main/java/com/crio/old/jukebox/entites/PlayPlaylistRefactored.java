package com.crio.old.jukebox.entites;

import java.util.List;
import java.util.Optional;

public class PlayPlaylistRefactored {
    private String userId;
    private List<Playlist> playlists;
    private Song currentSong;

    public PlayPlaylistRefactored(String userId, List<Playlist> playlists) {
        this.userId = userId;
        this.playlists = playlists;
        // this.song = song;
    }
    public void addPlayList(Playlist playlist){
        playlists.add(playlist);
    }

    public String getUserId() {
        return userId;
    }

    public void removePlayList(Playlist playlist){
        playlists.remove(playlist);
    }


    public Playlist getPlaylistById(String id) {
        return playlists.stream().filter(e->e.getId().equals(id)).findFirst().get();
    }
    public Song getCurrentSong(Playlist playlist){
        return playlist.getSongs().get(0);
    }
    public Song getSongById(Playlist playlist, String songId) {
     Optional<Song> temp= playlist.getSongs().stream().filter(song -> songId.equals(song.getId())).findFirst();
        return temp.get();
    }
    public List<Song> getSongList(Playlist playlist){
        return playlist.getSongs();
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}
