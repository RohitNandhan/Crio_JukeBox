package com.crio.jukebox.services;

import com.crio.jukebox.dto.PlayListUpdateResponse;
import com.crio.jukebox.entites.PlayListAction;
import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.entites.User;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;

import java.util.LinkedList;
import java.util.List;

public class PlaylistService implements IPlaylistService{
    private IUserRepository userRepository;
    private ISongRepository songRepository;
    private IPlaylistRepository playlistRepository;
    private static int counter=0;

    public PlaylistService(IUserRepository userRepository, ISongRepository songRepository, IPlaylistRepository playlistRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;

    }

    @Override
    public String createPlaylist(String userID, String playlistName, List<String> songIds) throws NoSuchSongException {
        User user=userRepository.getUserById(userID);
        String playlistID=String.valueOf(++counter);
        List<Song> songs=new LinkedList<>();
        songs=getSongsByListOfSongids(songIds);

        Playlist playlist=new Playlist(playlistID,user,playlistName,songs);
        playlistRepository.savePlaylist(userID,playlist);

        return playlistID;
    }


    @Override
    public boolean deletePlaylist(String userId, String playlistId) throws PlaylistNotFoundException {
        return  playlistRepository.deletePlaylist(userId,playlistId);
    }

    @Override
    public List<Song> getSongsByListOfSongids(List<String> songIds) throws NoSuchSongException {
        List<Song> songs = new LinkedList<>();
        for (String s : songIds) {
            try {
                Song newSong = songRepository.getSongById(s);
                if (!songs.contains(newSong))
                    songs.add(newSong);
            } catch (NoSuchSongException e) {
                throw new NoSuchSongException("Some Requested Songs Not Available. Please try again.");
            }
        }
        return songs;
    }

    @Override
    public PlayListUpdateResponse modifyPlaylist(String playListAction, String userID, String playlistId, List<String> songIds) throws NoSuchSongException, PlaylistNotFoundException {
            List<Song> songs;
        List<String> newSongIds = null;
        if(playListAction.equals("ADD-SONG")){
            try {
                songs=getSongsByListOfSongids(songIds);
                newSongIds = playlistRepository.addSong(userID,playlistId,songs);
            }catch (NoSuchSongException e){
                throw new NoSuchSongException("Some Requested Songs Not Available. Please try again.");
            }

        }else if(playListAction.equals("DELETE-SONG")){
            try {
                songs=getSongsByListOfSongids(songIds);
                newSongIds=playlistRepository.deleteSong(userID,playlistId,songs);
            }catch (NoSuchSongException e){
                throw new NoSuchSongException("Some Requested Songs for Deletion are not present in the playlist. Please try again.");
            }
        }
        Playlist playlist=playlistRepository.getPlaylistsById(userID,playlistId);
        return new PlayListUpdateResponse(playlist.getId(),playlist.getName(),newSongIds);
    }


}
