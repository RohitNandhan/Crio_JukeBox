package com.crio.jukebox.services;

import com.crio.jukebox.dto.PlayListUpdateResponse;
import com.crio.jukebox.entites.PlayListAction;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;

import java.util.List;

public interface IPlaylistService {
    String createPlaylist(String userID, String playlistName, List<String> songid) throws NoSuchSongException;
    boolean deletePlaylist(String userId, String playlistId) throws PlaylistNotFoundException;
   // PlayListUpdateResponse modifyPlaylist(String userID, String playlistId, List<String> songid);


    List<Song> getSongsByListOfSongids(List<String> songIds) throws NoSuchSongException;

    PlayListUpdateResponse modifyPlaylist(String action, String userID, String playlistId, List<String> songIds) throws NoSuchSongException, PlaylistNotFoundException;
}
