package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.Song;
import com.crio.jukebox.exceptions.NoSuchSongException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SongRepositoryTest {
    ISongRepository songRepository;
    @BeforeEach
    void setUp() {
       songRepository=new SongRepository();
    }

    @BeforeEach
    void loadSongs() {
        String filepath="songs.csv";
        songRepository.loadSongs(filepath);
//       songRepository.getAllSongs().forEach(song -> {
//            System.out.println(song);
//
//       });


    }

    @Test
    void getAllSongs() {
        int songsize=songRepository.getAllSongs().size();
        Assertions.assertEquals(30,songsize);
    }

    @Test
    void saveSong() throws NoSuchSongException {
     Song song=  songRepository.getSongById("30");
       Assertions.assertFalse(songRepository.saveSong(song));
    }

    @Test
    void getSongById() {

    }

    @Test
    void getSongByName() throws NoSuchSongException {
      //  loadSongs();

       Song song= songRepository.getSongByName("BLOOD.");
       // System.out.println(song);
        String expected="Song{songName='BLOOD.', genre='Hip-Hop', album='DAMN.', albumArtist='Kendrick Lamar', artists=[Kendrick Lamar], id='136'}";
        Assertions.assertEquals(expected,song.toString());
        System.out.println("---");
    }
    @Test
    void getSongByNameThrowException() throws NoSuchSongException {

        String expected="Song{songName='BLOOD.', genre='Hip-Hop', album='DAMN.', albumArtist='Kendrick Lamar', artists=[Kendrick Lamar], id='16'}";
        Assertions.assertThrows(NoSuchSongException.class,()->songRepository.getSongByName("BLooD"));
        System.out.println("---");
    }



    @Test
    void testLoadSongs() {
    }
}