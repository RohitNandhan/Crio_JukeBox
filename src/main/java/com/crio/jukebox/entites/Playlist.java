package com.crio.jukebox.entites;

import java.util.List;

public class Playlist extends BaseEntity {
    private User user;
    private List<Song> songList;
    private String name;

    public Playlist(String id, User user, String name, List<Song> songs) {
        super(id);
        this.user = user;
        this.songList = songs;
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public List<Song> getSongs() {
        return songList;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongList() {
        return songList;
    }
    public boolean isSongExist(String songID){
        return songList.stream().anyMatch(e->songID.equals(e.getId()));
    }

    public void addSong(Song song){
        this.songList.add(song);
    }
    public boolean removeSong(Song song){
        return  this.songList.remove(song);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "user=" + user +
                ", songs=" + songList +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
    public void display(){
        System.out.println("Playlist ID - "+id);
    }
}
