package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.PlayPlaylistRefactored;
import com.crio.old.jukebox.entites.Playlist;
import com.crio.old.jukebox.entites.Song;

import java.util.*;

public class PlaylistRepositoryRefactor implements IPlaylistRepositoryRefactor {
    private final Map<String, PlayPlaylistRefactored> playlistMap;

    public PlaylistRepositoryRefactor() {
        this.playlistMap = new LinkedHashMap<>();
    }

    @Override
    public PlayPlaylistRefactored getPlayPlaylist(String userId){
        return playlistMap.get(userId);
    }
    @Override
    public void savePlaylist(String userId, Playlist playlist) {
        if(playlistMap.containsKey(userId)){
            playlistMap.get(userId).addPlayList(playlist);
        }else {
            playlistMap.put(userId, new PlayPlaylistRefactored(userId,new ArrayList<>(Arrays.asList(playlist))));
        }
    }

//    @Override
//    public List<Playlist> getPlaylists(String userId) {
//        return playlistMap.get(userId).getPlaylists();
//    }
    @Override
    public Playlist getPlaylistsById(String userId, String playlistId) {
        return playlistMap.get(userId).getPlaylistById(playlistId);
    }


    @Override
    public void deletePlaylist(String userId, String playlistId) {
        Playlist playlist=getPlaylistsById(userId,playlistId);
        playlistMap.get(userId).removePlayList(playlist);
    }


    @Override
    public void addSong(String userId, String playlistId, List<Song> songList) {
            songList.stream().forEach(song -> {
                playlistMap.get(userId).getPlaylistById(playlistId).addSong(song);
            });
    }


        @Override
        public void deleteSong(String userId, String playlistId, List<Song> songList) {
            songList.stream().forEach(song -> {
                playlistMap.get(userId).getPlaylistById(playlistId).removeSong(song);
            });
        }
    }




