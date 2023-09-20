package com.crio.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.repositories.ISongRepository;

import java.util.List;

public class SongService implements ISongService{
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    } @Override
    public String loadSongFromFile(String fileName){
        songRepository.loadSongs(fileName);
        return "Songs Loaded successfully";
    }
}
