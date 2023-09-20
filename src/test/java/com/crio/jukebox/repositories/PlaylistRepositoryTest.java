package com.crio.jukebox.repositories;

import com.crio.jukebox.dto.PlayListUpdateResponse;
import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.entites.User;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistRepositoryTest {
    IPlaylistRepository playlistRepository;
    Playlist playlist1;
    Playlist playlist2;
    Playlist playlist3;

    User user;
    @BeforeEach
    void setUp(){
        playlistRepository=new PlaylistRepository();
        user= new User("1","ro");
        Song song= new Song("1","pop","CCC","xxx","yyy", Arrays.asList("zzz"));

        playlist1=new Playlist("1",user,"P1",new ArrayList<>(Arrays.asList(song)));
         playlist2=new Playlist("2",user,"P2",new ArrayList<>());
         playlist3=new Playlist("3",user,"P2",new ArrayList<>());

        playlistRepository.savePlaylist(user.getId(),playlist1);
        playlistRepository.savePlaylist(user.getId(),playlist2);
        playlistRepository.savePlaylist(user.getId(),playlist3);
    }

    @Test
    void getPlaylistsByUser() {
      int actualcount= playlistRepository.getPlaylistsByUser("1").getPlaylists().size();
        Assertions.assertEquals(3,actualcount);
    }

    @Test
    void savePlaylist() {
        Playlist playlist4=new Playlist("3",user,"P2",new ArrayList<>());
        boolean actualans=playlistRepository.savePlaylist(user.getId(),playlist4);
        Assertions.assertFalse(actualans);
    }

    @Test
    void getPlaylistsById() {
    }

    @Test
    void existsById() {

    }

    @Test
    void deletePlaylist() throws PlaylistNotFoundException {
       // Playlist playlist4=new Playlist("4",user,"P2",new ArrayList<>());
       boolean actual= playlistRepository.deletePlaylist(user.getId(),playlist1.getId());
       Assertions.assertTrue(actual);
    }

    @Test
    void addSong() {
        Song song1= new Song("3","pop","CCC","xxx","yyy", Arrays.asList("zzz"));
        Song song2= new Song("4","pop","CCC","xxx","yyy", Arrays.asList("zzz"));

      List actual=playlistRepository.addSong(user.getId(), playlist1.getId(),Arrays.asList(song1,song2));
       Assertions.assertEquals(3,actual.size());
    }

    @Test
    void deleteSong() {
        Song song1= new Song("3","pop","CCC","xxx","yyy", Arrays.asList("zzz"));
        Song song2= new Song("4","pop","CCC","xxx","yyy", Arrays.asList("zzz"));

        Playlist playlist5=new Playlist("5",user,"P2",new ArrayList<>(Arrays.asList(song1,song2)));
        playlistRepository.savePlaylist(user.getId(),playlist5);
        List actual=playlistRepository.deleteSong(user.getId(), playlist5.getId(), Arrays.asList(song1,song2));
       Assertions.assertEquals(0,actual.size());
    }
}