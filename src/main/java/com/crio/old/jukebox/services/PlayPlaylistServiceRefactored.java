package com.crio.old.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.old.jukebox.entites.PlayAction;
import com.crio.old.jukebox.entites.PlayPlaylistRefactored;
import com.crio.old.jukebox.entites.Playlist;
import com.crio.old.jukebox.entites.Song;
import com.crio.old.jukebox.repositories.IPlayPlayListRepository;
import com.crio.old.jukebox.repositories.IPlaylistRepositoryRefactor;
import com.crio.old.jukebox.repositories.ISongRepository;
import com.crio.old.jukebox.repositories.IUserRepository;

import java.util.Iterator;
import java.util.List;

public class PlayPlaylistServiceRefactored implements IPlayPlaylist {
    private IUserRepository userRepository;
    private ISongRepository songRepository;
    private IPlaylistRepositoryRefactor playlistRepository;
    private IPlayPlayListRepository playPlaylistRepository;

    private Playlist currentPlayList;
    private PlayPlaylistRefactored currentPlayPlaylist;
    private String currentSongId;



    public PlayPlaylistServiceRefactored(IUserRepository userRepository, ISongRepository songRepository, IPlaylistRepositoryRefactor playlistRepository, IPlayPlayListRepository playPlaylistRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
        this.playPlaylistRepository=playPlaylistRepository;
    }
    @Override
    public List<Song> getSongsByPlaylistId(String playlistId) {
        return null;
    }

    @Override
    public List<Song> getSongsByPlaylistName(String playlistName) {
        return null;
    }

    @Override
    public PlayResponse playPlaylist(String userId, String playListId) {
     // currentPlayList=playlistRepository.getPlaylistById(playListId);
        currentPlayPlaylist=playlistRepository.getPlayPlaylist(userId);
        currentPlayList=playlistRepository.getPlaylistsById(userId,playListId);
        Song song= play(userId);
        return new PlayResponse(song.getSongName(),song.getAlbum(),song.getArtists());
    }

    public Song play(String userId) {

        return currentPlayPlaylist.getCurrentSong(currentPlayList);
    }
    private Song playSongByID(String userId, String songId){
        //  if(currentPlayList)
        currentSongId=songId;
        return currentPlayPlaylist.getSongById(currentPlayList,songId);
    }
    @Override
    public PlayResponse playSong(String userID, String action){
      Song song =  playPlaylistRepository.play(userID,action);
        return new PlayResponse(song.getSongName(),song.getAlbum(),song.getArtists());
            }


    public Song play(String userId, String action) {
        Iterator<String> itr=currentPlayList.getSongs().stream().map(e->e.getId()).iterator();
        String id=currentSongId;
        String songId=null;
        if(PlayAction.valueOf(action)== PlayAction.NEXT){
            songId = findNext(id,itr);
            return currentPlayPlaylist.getSongById(currentPlayList,songId);
        }else if(PlayAction.valueOf(action)== PlayAction.BACK){
            songId = findPrev(id,itr);
            return currentPlayPlaylist.getSongById(currentPlayList,songId);
        }else {
            return playSongByID(userId, action);
        }
    }
    private String findPrev(String id,Iterator<String> itr){
        while (itr.hasNext()){
            String prev;
            if((prev= itr.next())==id){
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
        if(itr.hasNext())
            start =itr.next();
        if(start==id){
            return itr.next();
        }
        while (itr.hasNext()) {
            if ((itr.next())==id) {
                if (itr.hasNext())
                    return  itr.next();
            }
        } return start;

    }
//
//    public boolean checkPlaylist(String userid){
//        if(currentPlayPlaylist==playlistRepository.{
//            return true;
//        }else {
//            // currentPlayList=playPlaylistMap.get(userid);
//            return false;
//        }
    }


