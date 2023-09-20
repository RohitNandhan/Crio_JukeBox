package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> getAllSongs();
    void saveSong(Song song);
    Song getSongById(String songId);
    Song getSongByName(String songName);
    Song nextSong(String id);

    Song prevSong(String id);
}
