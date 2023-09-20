package com.crio.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotExistException;

import java.util.List;

public interface IPlayPlaylistService {
    List<Song> getSongsByPlaylistId(String playlistId);
    Song getSongBySongId(String songId);
    PlayResponse playPlaylist(String userId, String playListId) throws PlaylistNotFoundException, SongNotExistException;
    PlayResponse playSong(String userID, String action) throws NoSuchSongException;
    Song play(String userId, String action) throws NoSuchSongException;
}
