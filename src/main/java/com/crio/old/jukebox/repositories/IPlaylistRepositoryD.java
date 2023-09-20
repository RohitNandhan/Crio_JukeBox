package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.Playlist;
import com.crio.old.jukebox.entites.Song;

import java.util.List;

public interface IPlaylistRepositoryD {
    void savePlaylist(Playlist playlist);

    Playlist getPlaylistById(String playlistId);

    void deletePlaylist(String playlistId);

    void addSong(String playlistId, List<Song> songList);

    void deleteSong(String playlistId, List<Song> songList);
}
