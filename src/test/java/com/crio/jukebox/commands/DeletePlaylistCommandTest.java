package com.crio.jukebox.commands;

import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("DeletePlayListCommandTest")
@ExtendWith(MockitoExtension.class)
class DeletePlaylistCommandTest {

    private final PrintStream sOut=System.out;
    private final ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();

    @Mock
    IPlaylistService playlistServiceMock;
    @InjectMocks
    DeletePlaylistCommand deletePlaylistCommandMock;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    @DisplayName("execute method of DeletePlaylistCommand, print Delete Successfull")
    void execute() throws PlaylistNotFoundException {
        String expectedOutput="Delete Successful";
        boolean exp=true;
        when(playlistServiceMock.deletePlaylist(anyString(),anyString())).thenReturn(exp);
        deletePlaylistCommandMock.execute(Arrays.asList("DELETE_COMMAND","1","1"));

        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString());
        verify(playlistServiceMock,times(1)).deletePlaylist(anyString(),anyString());
    }

    @Test
    @DisplayName("execute method of DeletePlaylistCommand, to throw PlaylistNotFoundException")
    void execute_throwsException() throws PlaylistNotFoundException {
        String expectedOutput="Playlist Not Found";
        doThrow(new PlaylistNotFoundException(expectedOutput)).when(playlistServiceMock).deletePlaylist(anyString(),anyString());

        deletePlaylistCommandMock.execute(Arrays.asList("DELETE_COMMAND","1","1"));
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString());
        verify(playlistServiceMock,times(1)).deletePlaylist(anyString(),anyString());
    }
}