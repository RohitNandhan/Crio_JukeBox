package com.crio.old.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.old.jukebox.entites.Song;

import java.util.List;

public class SongService implements ISongService {
    @Override
    public PlayResponse playNextSong(String UserId) {
        return null;
    }

    @Override
    public PlayResponse playPrevSong(String UserId) {
        return null;
    }

    @Override
    public PlayResponse playSong(String UserId, String songId) {
        return null;
    }

    @Override
    public List<Song> getAllSongs() {
        return null;
    }

    @Override
    public Song getSongById(String id) {
        return null;
    }

    @Override
    public Song getSongByName(String name) {
        return null;
    }

    @Override
    public List<Song> getSongsByAlbum(String albumName) {
        return null;
    }
}
