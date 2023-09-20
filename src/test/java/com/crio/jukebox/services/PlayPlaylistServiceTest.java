package com.crio.jukebox.services;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.entites.PlayAction;
import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.entites.User;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotExistException;
import com.crio.jukebox.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayPlaylistServiceTest {
    PlayPlaylistService playPlaylistService;
        IUserRepository userRepository=new UserRepository();
        ISongRepository songRepository=new SongRepository();
        IPlaylistRepository playlistRepository=new PlaylistRepository();
    User user;
    @BeforeEach
    void setUp(){
        user= new User("1","ro");
        Song song= new Song("1","pop","CCC","xxx","yyy", Arrays.asList("zzz"));

        Playlist playlist1 = new Playlist("1", user, "P1", new ArrayList<>(Arrays.asList(song)));
        Playlist playlist2=new Playlist("2",user,"P2",new ArrayList<>());
        Playlist playlist3=new Playlist("3",user,"P2",new ArrayList<>());
        userRepository.saveUser(user);
        songRepository.loadSongs("songs.csv");

//        playlistRepository.savePlaylist(user.getId(),playlist1);
//        playlistRepository.savePlaylist(user.getId(),playlist2);
//        playlistRepository.savePlaylist(user.getId(),playlist3);
        PlaylistService playlistService=new PlaylistService(userRepository,songRepository,playlistRepository);
        try {
            playlistService.createPlaylist(user.getId(),"P1",Arrays.asList("1","2","3"));
            playlistService.createPlaylist(user.getId(),"P2",Arrays.asList("1","2","3","4","9"));
        } catch (NoSuchSongException e) {
            throw new RuntimeException(e);
        }

        playPlaylistService =new PlayPlaylistService(userRepository,songRepository,playlistRepository);

    }

    @Test
    void getSongsByPlaylistId() {

//        playPlaylistService.getSongsByPlaylistId("1").forEach(e->{
//            System.out.println(e);
//        });
      playPlaylistService.getSongBySongId("1");
    }

    @Test
    void getSongBySongId() {
    }

    @Test
    void getSongsByPlaylistName() {
    }

    @Test
    void playPlaylist() throws PlaylistNotFoundException, SongNotExistException, NoSuchSongException {
       PlayResponse playResponse= playPlaylistService.playPlaylist(user.getId(),"2");
       PlayResponse playResponse1= playPlaylistService.playSong(user.getId(), "NEXT");
        PlayResponse playResponse2= playPlaylistService.playSong(user.getId(), "BACK");


        PlayResponse playResponse3= playPlaylistService.playSong(user.getId(), "3");
        PlayResponse playResponse4= playPlaylistService.playSong(user.getId(), "NEXT");

        System.out.println(playResponse);
        System.out.println(playResponse1);
        System.out.println(playResponse2);
        System.out.println(playResponse3);
        System.out.println(playResponse4);
    }

    @Test
    void play() {

    }

    @Test
    void playSong() {
    }

    @Test
    void testPlay() {
    }
}