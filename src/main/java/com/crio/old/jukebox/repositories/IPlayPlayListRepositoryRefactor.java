package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.Playlist;
import com.crio.old.jukebox.entites.Song;

public interface IPlayPlayListRepositoryRefactor {
    boolean checkPlaylistById(String id);

    Song play(String userId);

    void addPlayingPlaylist(String userID, Playlist playlist);

    Song play(String userId, String action);

    boolean checkPlaylist(String userid);
}
