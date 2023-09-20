package com.crio.old.jukebox.services;

import com.crio.old.jukebox.entites.Playlist;
import com.crio.old.jukebox.entites.Song;
import com.crio.old.jukebox.entites.User;
import com.crio.old.jukebox.repositories.IPlaylistRepositoryRefactor;
import com.crio.old.jukebox.repositories.ISongRepository;
import com.crio.old.jukebox.repositories.IUserRepository;

import java.util.List;

public class PlaylistService implements IPlaylistService {
    private IUserRepository userRepository;
    private ISongRepository songRepository;
    private IPlaylistRepositoryRefactor playlistRepository;

    public PlaylistService(IUserRepository userRepository, ISongRepository songRepository, IPlaylistRepositoryRefactor playlistRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;

    }

    @Override
    public String createPlaylist(String playlistID, String playlistName, String userId, List<Song> songList) {
        User user=userRepository.getUserById(userId);
        Playlist playlist=new Playlist(playlistID,user,playlistName,songList);
        playlistRepository.savePlaylist(userId,playlist);
        //// TODO: make return statement
        return null;
    }

    @Override
    public String deletePlaylist(String userId,String playlistId) {
        playlistRepository.deletePlaylist(userId,playlistId);
        return null;
    }

    @Override
    public String modifyPlaylist(String playlistID, String playlistName, String userId, List<Song> songList) {
        return null;
    }

//    @Override
//    public List<Song> getSongsByPlaylistId(String playlistId) {
//        return null;
//    }
//
//    @Override
//    public List<Song> getSongsByPlaylistName(String playlistName) {
//        return null;
//    }
//
//    @Override
//    public PlayResponse playPlaylist(String userId, String playListId) {
//        User user=userRepository.getUserById(userId);
//        Playlist playlist=playlistRepository.getPlaylistById(playListId);
//        return ;
//    }
}
