package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.NoSuchSongException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SongRepository implements ISongRepository{
    private final LinkedHashMap<String,Song> songMap;
    private static int counter=0;

    public SongRepository() {
        this.songMap =new LinkedHashMap<>();
    }

    @Override
    public List<Song> getAllSongs() {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean saveSong(Song song) {

        if(!existsById(song.getId())) {
            songMap.put(song.getId(), song);
            return true;
        }else return false;
    }

    @Override
    public Song getSongById(String songId) throws NoSuchSongException {
        if(existsById(songId))
        return songMap.get(songId);
        else throw new NoSuchSongException();
    }

    @Override
    public boolean existsById(String id) {
        return songMap.containsKey(id);
    }

    @Override
    public Song getSongByName(String songName) throws NoSuchSongException{
        Optional<Song> temp=songMap.values().stream().filter(e->songName.equals(e.getSongName())).findFirst();
        if(!temp.isPresent()){
           throw new NoSuchSongException();
        }
        return  temp.get();
    }

    @Override
    public void loadSongs(File file) {

    }

    @Override
    public void loadSongs(String filePath) {
        try{

            BufferedReader reader=new BufferedReader(new FileReader(filePath));
           String line= reader.readLine();

            while (line !=null){
                String id=String.valueOf(++counter);
              List<String> fields=  Arrays.asList(line.split(","));
               Song addSong=new Song(id,fields.get(0),fields.get(1),fields.get(2),fields.get(3),Arrays.asList(fields.get(4).split("#")));
               saveSong(addSong);
              line=  reader.readLine();
            }reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Song> findById(String id) {
        return Optional.empty();
    }


}
