package com.crio.jukebox.commands;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotExistException;
import com.crio.jukebox.services.PlayPlaylistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class Play_SongCommandTest {

    ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();

    @Mock
    PlayPlaylistService playPlaylistServiceMock;

    @InjectMocks
    Play_SongCommand playSongCommand;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void execute() throws PlaylistNotFoundException, SongNotExistException, NoSuchSongException {
        PlayResponse expectedAns=new PlayResponse("song","album", Arrays.asList("a","b","c"));
        when(playPlaylistServiceMock.playSong(anyString(),anyString())).thenReturn(expectedAns);

        playSongCommand.execute(Arrays.asList("PLAYCOMMAND","userid","playlistid"));

        Assertions.assertEquals(expectedAns.toString(),outputStreamCaptor.toString());
        verify(playPlaylistServiceMock,times(1)).playSong(anyString(),anyString());
    }

    @Test
    void execute_throwsException() throws NoSuchSongException {
        String output="Song Not Found in the current active playlist.";
        doThrow(new NoSuchSongException(output)).when(playPlaylistServiceMock).playSong(anyString(),anyString());
        playSongCommand.execute(Arrays.asList("PLAYCOMMAND","userid","playlistid"));
        Assertions.assertEquals(output,outputStreamCaptor.toString());
        verify(playPlaylistServiceMock,times(1)).playSong(anyString(),anyString());

    }
}