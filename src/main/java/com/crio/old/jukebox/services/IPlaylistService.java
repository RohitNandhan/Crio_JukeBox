package com.crio.old.jukebox.services;

import com.crio.old.jukebox.entites.Song;

import java.util.List;

public interface IPlaylistService {
    String createPlaylist(String playlistID, String playlistName, String userId, List<Song> songList);
    String deletePlaylist(String userId,String playlistId);
    String modifyPlaylist(String playlistID, String playlistName, String userId, List<Song> songList);


}
