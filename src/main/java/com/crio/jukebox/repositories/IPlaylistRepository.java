package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.ActivePlaylist;
import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;

import java.util.List;

public interface IPlaylistRepository {
    ActivePlaylist getPlaylistsByUser(String userId) ;

    boolean savePlaylist(String userId, Playlist playlist);

    Playlist getPlaylistsById(String userId, String playlistId) throws PlaylistNotFoundException;

    boolean existsById(String userId,String playlistId);

    boolean deletePlaylist(String userId, String playlistId) throws PlaylistNotFoundException;

    List<String> addSong(String userId, String playlistId, List<Song> songList);

    List<String> deleteSong(String userId, String playlistId, List<Song> songList);
}
