package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.PlayAction;
import com.crio.old.jukebox.entites.Song;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongRepository implements ISongRepository {
    private final LinkedHashMap<String, Song> songMap;

    public SongRepository() {
        this.songMap =new LinkedHashMap<>();
    }

    @Override
    public List<Song> getAllSongs() {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void saveSong(Song song) {
        songMap.put(song.getId(), song);
    }

    @Override
    public Song getSongById(String songId) {
        return songMap.get(songId);
    }

    @Override
    public Song getSongByName(String songName) {
        Optional<Song> temp=songMap.values().stream().filter(e->songName.equals(e.getSongName())).findFirst();
        return  temp.get();
    }

    @Override
    public Song nextSong(String id) {
       String nextSongid= findSong(id, PlayAction.NEXT);
        return songMap.get(nextSongid);
    }

    @Override
    public Song prevSong(String id) {
        String prevSongid= findSong(id, PlayAction.BACK);
        return songMap.get(prevSongid);
    }
    private String findSong(String id, PlayAction action) {
        Iterator<String> itr=songMap.keySet().iterator();
        if(action== PlayAction.NEXT){
            return findNext(id,itr);
        }else if(action== PlayAction.BACK){
            return findPrev(id, itr);
        }
        return null;
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
}
