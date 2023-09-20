package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.ActivePlaylist;
import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class PlaylistRepository implements IPlaylistRepository {
    private final Map<String, ActivePlaylist> playlistMap;

    public PlaylistRepository() {
        this.playlistMap = new LinkedHashMap<>();
    }

    @Override
    public ActivePlaylist getPlaylistsByUser(String userId){
        return playlistMap.get(userId);
    }
    @Override
    public boolean savePlaylist(String userId, Playlist playlist) {
        if(playlistMap.containsKey(userId)){
//            if(existsById(userId,playlist.getId())){
//                return ;
//            }
           return playlistMap.get(userId).addPlayList(playlist);
        }else {
            playlistMap.put(userId, new ActivePlaylist(userId,new ArrayList<>(Arrays.asList(playlist))));
            return true;
        }
    }

//    @Override
//    public List<Playlist> getPlaylists(String userId) {
//        return playlistMap.get(userId).getPlaylists();
//    }
    @Override
    public Playlist getPlaylistsById(String userId, String playlistId) throws PlaylistNotFoundException {
        if (existsById(userId,playlistId))
            return playlistMap.get(userId).getPlaylistById(playlistId);
        throw new PlaylistNotFoundException("Playlist Not Found");
    }

    @Override
    public boolean existsById(String userId,String playlistId) {
          return playlistMap.get(userId).isPlaylistExist(playlistId);
    }

    private List<String> getSongIdsFromSongList(List<Song> songList){
        return songList.stream().map(e->e.getId()).collect(Collectors.toList());
    }
    private List<Song> getSongsInPlaylist(String userid,String playlistId){
        return playlistMap.get(userid).getPlaylistById(playlistId).getSongList();
    }


    @Override
    public boolean deletePlaylist(String userId, String playlistId) throws PlaylistNotFoundException {
        Playlist playlist=getPlaylistsById(userId,playlistId);
        return playlistMap.get(userId).removePlayList(playlist);
    }

    @Override
    public List<String> addSong(String userId, String playlistId, List<Song> songList) {
            songList.stream().forEach(song -> {
                playlistMap.get(userId).getPlaylistById(playlistId).addSong(song);
                //getPlaylistsById(userID,playlistID).addSong(song);
            });
            return getSongIdsFromSongList(getSongsInPlaylist(userId,playlistId));
    }


        @Override
        public List<String> deleteSong(String userId, String playlistId, List<Song> songList) {
            songList.stream().forEach(song -> {
                playlistMap.get(userId).getPlaylistById(playlistId).removeSong(song);
            });
            return getSongIdsFromSongList(getSongsInPlaylist(userId,playlistId));
        }
    }




