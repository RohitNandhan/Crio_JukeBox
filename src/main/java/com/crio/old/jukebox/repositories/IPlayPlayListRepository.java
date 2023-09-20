package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.PlayPlaylist;
import com.crio.old.jukebox.entites.Song;

public interface IPlayPlayListRepository {
    PlayPlaylist getPlaylistById(String id);

    Song play(String userId);

    Song play(String userId, String action);

    void addPlayingPlaylist(String userID, PlayPlaylist playPlaylist);

    boolean checkPlaylist(String userid);
}
