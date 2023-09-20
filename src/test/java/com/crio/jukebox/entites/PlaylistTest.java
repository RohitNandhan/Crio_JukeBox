package com.crio.jukebox.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    Playlist playlist;
    User user;
    List<Song> songs;
    String playlistName;

    @BeforeEach
    void setUp(){
        String id="001";
       user =new User("1","ro");
        songs =new ArrayList<>();
        playlistName="newPlaylist";
        playlist=new Playlist(id,user,playlistName,songs);
    }

    @Test
    void getUser() {
        User expectedUser =user;
        User actualUser=playlist.getUser();
        Assertions.assertEquals(actualUser,expectedUser);
    }

    @Test
    void getSongs() {
        List expectedSongs=songs;
        List actualSongs=playlist.getSongs();
        Assertions.assertEquals(expectedSongs,actualSongs);
    }

    @Test
    void addSong() {
        List expectedSongs=songs;
        playlist.addSong(new Song("1","pop","AAA","xxx","yyy", Arrays.asList("yyy")));
        playlist.addSong(new Song("2","pop","BBB","xxx","yyy", Arrays.asList("yyy")));
        playlist.addSong(new Song("3","pop","CCC","xxx","yyy", Arrays.asList("zzz")));
        List actualSongs=playlist.getSongs();
        Assertions.assertEquals(expectedSongs.size(),actualSongs.size());
    }

    @Test
    void removeSong() {
       Song song= new Song("3","pop","CCC","xxx","yyy", Arrays.asList("zzz"));
       playlist.addSong(song);
      boolean actualAns= playlist.removeSong(song);
        Assertions.assertTrue(actualAns);
    }

    @Test
    void temp() {
        int counter=0;

        System.out.println("temp testIng");
    }
}