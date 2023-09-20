package com.crio.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.entites.*;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotExistException;
import com.crio.jukebox.repositories.*;

import java.util.Iterator;
import java.util.List;

public class PlayPlaylistService implements IPlayPlaylistService {
    private IUserRepository userRepository;
    private ISongRepository songRepository;
    private IPlaylistRepository playlistRepository;

    private Playlist currentPlayList;
    private ActivePlaylist currentActivePlaylist;
    private String currentSongId;

    public PlayPlaylistService(IUserRepository userRepository, ISongRepository songRepository, IPlaylistRepository playlistRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }
    @Override
    public List<Song> getSongsByPlaylistId(String playlistId) {
        return currentActivePlaylist.getPlaylistById(playlistId).getSongs();
    }
    @Override
    public Song getSongBySongId(String songId) {
        return currentActivePlaylist.getSongById(currentPlayList,songId);
    }


    @Override
    public PlayResponse playPlaylist(String userId, String playListId) throws PlaylistNotFoundException, SongNotExistException {
        currentActivePlaylist =playlistRepository.getPlaylistsByUser(userId);
        currentPlayList=playlistRepository.getPlaylistsById(userId,playListId);
        Song song= play(userId);
        return new PlayResponse(song.getSongName(),song.getAlbum(),song.getArtists());
    }

    public Song play(String userId) throws SongNotExistException {
        if(currentActivePlaylist.isSongsExist(currentPlayList)){
        currentSongId=currentActivePlaylist.getCurrentSong(currentPlayList).getId();
        return currentActivePlaylist.getCurrentSong(currentPlayList);
    }else throw new SongNotExistException("Playlist is empty");
    }
    private Song playSongByID(String userId, String songId) throws NoSuchSongException {
        if(currentPlayList.isSongExist(songId))
        return currentActivePlaylist.getSongById(currentPlayList,songId);
        else throw new NoSuchSongException("Given song id is not a part of the active playlist\n");
    }
    @Override
    public PlayResponse playSong(String userID, String action) throws NoSuchSongException {
      Song song =  play(userID,action);
        return new PlayResponse(song.getSongName(),song.getAlbum(),song.getArtists());
            }

    @Override
    public Song play(String userId, String action) throws NoSuchSongException {
        Iterator<String> itr=currentPlayList.getSongs().stream().map(e->e.getId()).iterator();
        String id=currentSongId;
        String songId=null;
        if(action.equalsIgnoreCase("NEXT")){
            songId = findNext(id,itr);
            currentSongId=songId;
            return currentActivePlaylist.getSongById(currentPlayList,songId);
        }else if(action.equalsIgnoreCase("BACK")){
            songId = findPrev(id,itr);
            currentSongId=songId;
            return currentActivePlaylist.getSongById(currentPlayList,songId);
        }else {
            currentSongId=action;
            return playSongByID(userId, action);
        }
    }
    private String findPrev(String id,Iterator<String> itr){
        while (itr.hasNext()){
            String prev;
            if((prev= itr.next()).equals(id)){
                while(itr.hasNext()){
                    prev= itr.next();
                }return prev;
            }
            if(itr.next()==id){
                return prev;
            }
        } return id;
    }
    private String findNext(String id,Iterator<String> itr){
        String start=null;
        String current=null;
        if(itr.hasNext())
            start =itr.next();
        if(start==id){
            return itr.next();
        }
        while (itr.hasNext()) {
            if ((current=(itr.next())).equals(id)) {
                if (itr.hasNext())
                    return  itr.next();
            }
        } return start;

    }
    }


