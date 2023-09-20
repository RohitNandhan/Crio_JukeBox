package com.crio.old.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.old.jukebox.entites.Song;

import java.util.List;

public interface ISongService {
    PlayResponse playNextSong(String UserId);
    PlayResponse playPrevSong(String UserId);
    PlayResponse playSong(String UserId, String songId);
    List<Song> getAllSongs();
    Song getSongById(String id);
    Song getSongByName(String name);
    List<Song> getSongsByAlbum(String albumName);
}
