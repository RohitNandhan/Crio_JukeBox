package com.crio.jukebox.commands;

import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.entites.Song;
import com.crio.jukebox.entites.User;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.services.IPlaylistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("CreateUserCommandTest")
@ExtendWith(MockitoExtension.class)
class CreatePlaylistCommandTest {

    private final PrintStream sOut=System.out;
    private final ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();

    @Mock
    IPlaylistService playlistServiceMock;

    @InjectMocks
     CreatePlaylistCommand createPlaylistCommandMock;

    @BeforeEach
    void setUp(){
       System.setOut(new PrintStream(outputStreamCaptor)); }

    @Test
    @DisplayName("execute method of CreateUser command ,print newly created user to console ")
    void execute() throws NoSuchSongException {
        String expectedOutput="1";
        User user=new User(eq("1"),"Ronan");
        List<Song> songList= Arrays.asList(
                new Song("1","pop","AAA","xxx","yyy", Arrays.asList("yyy")),
                new Song("2","pop","AAA","xxx","yyy", Arrays.asList("yyy"))
        );
        Playlist playlist=new Playlist("1",user,"P1",songList);
        when(playlistServiceMock.createPlaylist("1",anyString(),anyList())).thenReturn(playlist.getId());

        createPlaylistCommandMock.execute(Arrays.asList("CREATE-USER","1","P1","1","2","3"));
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString());

        verify(playlistServiceMock,times(1)).createPlaylist(anyString(),anyString(),anyList());
    }

    @Test
    @DisplayName("execute method , throws noSuchSongFoundException")
    void execute_throwException() throws NoSuchSongException {
        String expectedOutput="Some Requested Songs Not Available. Please try again.";
        doThrow(new NoSuchSongException(expectedOutput)).when(playlistServiceMock).createPlaylist(eq("1"),anyString(),anyList());

        createPlaylistCommandMock.execute(Arrays.asList("CREATE-USER","1","P1","1","2","3"));
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
        verify(playlistServiceMock,times(1)).createPlaylist(anyString(),anyString(),anyList());

    }


}

