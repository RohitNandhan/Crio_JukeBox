package com.crio.jukebox.entites;

import java.util.List;
import java.util.Optional;

public class ActivePlaylist {
    private String userId;
    private List<Playlist> playlists;
    private Song currentSong;

    public ActivePlaylist(String userId, List<Playlist> playlists) {
        this.userId = userId;
        this.playlists = playlists;
        // this.song = song;
    }
    public boolean addPlayList(Playlist playlist){
        if(!isPlaylistExist(playlist.getId()))
         return playlists.add(playlist);
       return false;
    }
    public boolean isPlaylistExist(String playlistId){
        if(playlists.stream().anyMatch(e->playlistId.equals(e.getId())))
            return true;
        return false;
    }

    public String getUserId() {
        return userId;
    }

    public boolean removePlayList(Playlist playlist){
        return playlists.remove(playlist);
    }


    public Playlist getPlaylistById(String id) {
        return playlists.stream().filter(e->e.getId().equals(id)).findFirst().get();
    }
    public boolean isSongsExist(Playlist playlist){
        return ((playlist.getSongs().size()!=0)?true:false);
    }

    public Song getCurrentSong(Playlist playlist){
        return playlist.getSongs().get(0);
    }
    public Song getSongById(Playlist playlist,String songId) {
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
