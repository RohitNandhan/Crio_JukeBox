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
class Play_PlaylistCommandTest extends ICommandTest{

    ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();
    @Mock
    PlayPlaylistService playPlaylistService;
    @InjectMocks
    Play_PlaylistCommand playPlaylistCommand;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void execute() throws PlaylistNotFoundException, SongNotExistException {
        PlayResponse playResponse=new PlayResponse("song","album", Arrays.asList("a","b","c"));
        when(playPlaylistService.playPlaylist(anyString(),anyString())).thenReturn(playResponse);

        playPlaylistCommand.execute(Arrays.asList("PLAYPLAYLIST","userId","playListId"));

        Assertions.assertEquals(playResponse.toString(),outputStreamCaptor.toString());
        verify(playPlaylistService,times(1)).playPlaylist(anyString(),anyString());
    }

    @Test
    void execute_throwsSongNotExistException() throws PlaylistNotFoundException, SongNotExistException {
        String output="Song Not Found in the current active playlist";
        doThrow(new SongNotExistException(output)).when(playPlaylistService).playPlaylist(anyString(),anyString());

        playPlaylistCommand.execute(Arrays.asList("PLAYPLAYLIST","userId","playListId"));

        Assertions.assertEquals(output,outputStreamCaptor.toString());
        verify(playPlaylistService,times(1)).playPlaylist(anyString(),anyString());
    }
    @Test
    void execute_throwsPlaylistNotFoundException() throws PlaylistNotFoundException, SongNotExistException {
        String output="Playlist not found";
        doThrow(new PlaylistNotFoundException(output)).when(playPlaylistService).playPlaylist(anyString(),anyString());

        playPlaylistCommand.execute(Arrays.asList("PLAYPLAYLIST","userId","playListId"));

        Assertions.assertEquals(output,outputStreamCaptor.toString());
        verify(playPlaylistService,times(1)).playPlaylist(anyString(),anyString());
    }
}