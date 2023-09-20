package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.PlayPlaylistRefactored;
import com.crio.old.jukebox.entites.Playlist;
import com.crio.old.jukebox.entites.Song;

import java.util.List;

public interface IPlaylistRepositoryRefactor {
    PlayPlaylistRefactored getPlayPlaylist(String userId);

    void savePlaylist(String userId, Playlist playlist);

    //    @Override
    //    public List<Playlist> getPlaylists(String userId) {
    //        return playlistMap.get(userId).getPlaylists();
    //    }
    Playlist getPlaylistsById(String userId, String playlistId);

    void deletePlaylist(String userId, String playlistId);

    void addSong(String userId, String playlistId, List<Song> songList);

    void deleteSong(String userId, String playlistId, List<Song> songList);
}
