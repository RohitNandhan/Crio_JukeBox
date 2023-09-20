package com.crio.old.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.old.jukebox.entites.Song;

import java.util.List;

public interface IPlayPlaylist {
    List<Song> getSongsByPlaylistId(String playlistId);
    List<Song> getSongsByPlaylistName(String playlistName);
    PlayResponse playPlaylist(String userId, String playListId);

    PlayResponse playSong(String userID, String action);
}
