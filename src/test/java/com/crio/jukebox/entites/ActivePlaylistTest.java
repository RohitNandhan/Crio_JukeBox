package com.crio.jukebox.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ActivePlaylistTest {
    Playlist playlist;
    User user;
    List<Song> songs;
    String playlistName;
    String id;

    ActivePlaylist activePlaylist;

    @BeforeEach
    void setUp(){
         id="001";
        user =new User("1","ro");
        songs =new ArrayList<>();
        playlistName="newPlaylist";
        playlist=new Playlist(id,user,playlistName,songs);
        activePlaylist =new ActivePlaylist(user.getId(),new ArrayList<>(Arrays.asList(playlist)));
    }

    @Test
    void addPlayList() {
        System.out.println();
        System.out.println(activePlaylist.getPlaylists());
        Assertions.assertFalse(activePlaylist.addPlayList(playlist));
    }

    @Test
    void getUserId() {
        Assertions.assertEquals("1",activePlaylist.getUserId());
    }

    @Test
    void removePlayList() {
        System.out.println(activePlaylist.removePlayList(null));
        Assertions.assertFalse(activePlaylist.removePlayList(null));
    }

    @Test
    void getPlaylistById() {
        Assertions.assertEquals("001",activePlaylist.getPlaylistById(id).getId());
    }

    @Test
    void getCurrentSong() {

    }

    @Test
    void getSongById() {
        playlist.addSong(new Song("1","pop","AAA","xxx","yyy", Arrays.asList("yyy")));
        playlist.addSong(new Song("2","pop","BBB","xxx","yyy", Arrays.asList("yyy")));
        playlist.addSong(new Song("3","pop","CCC","xxx","yyy", Arrays.asList("zzz")));
        Assertions.assertEquals(songs.stream().filter(e->e.getId()=="2").findAny().get(),activePlaylist.getSongById(playlist,"2"));
    }

    @Test
    void getSongList() {
        playlist.addSong(new Song("1","pop","AAA","xxx","yyy", Arrays.asList("yyy")));
        playlist.addSong(new Song("2","pop","BBB","xxx","yyy", Arrays.asList("yyy")));
       Assertions.assertEquals(2,activePlaylist.getSongList(playlist).size());
        System.out.println(songs);
    }

    @Test
    void isPlaylistExist(){
       boolean actual= activePlaylist.isPlaylistExist("001");
       Assertions.assertTrue(actual);
    }


    @Test
    void getPlaylists() {
            Assertions.assertEquals(1,activePlaylist.getPlaylists().size());
    }
}