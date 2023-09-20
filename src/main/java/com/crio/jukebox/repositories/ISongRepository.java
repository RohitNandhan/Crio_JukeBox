package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.NoSuchSongException;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface ISongRepository {
    List<Song> getAllSongs();
    boolean saveSong(Song song);
    Song getSongById(String songId) throws NoSuchSongException;
    boolean existsById(String id);

    Song getSongByName(String songName) throws NoSuchSongException;

    void loadSongs(File file);

    void loadSongs(String filePath);

    public Optional<Song> findById(String id);


}
