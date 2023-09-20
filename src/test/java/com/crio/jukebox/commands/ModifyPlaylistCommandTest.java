package com.crio.jukebox.commands;

import com.crio.jukebox.dto.PlayListUpdateResponse;
import com.crio.jukebox.entites.PlayListAction;
import com.crio.jukebox.entites.Playlist;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.services.PlaylistService;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModifyPlaylistCommandTest extends ICommandTest<ModifyPlaylistCommand,PlaylistService> {
    @Mock
    PlaylistService playlistServiceMock;
    @InjectMocks
    ModifyPlaylistCommand commandMock;

    @Test
    void execute() throws NoSuchSongException, PlaylistNotFoundException {
        PlayListUpdateResponse playListUpdateResponse=new PlayListUpdateResponse("001","P1", Arrays.asList("1","2","3"));
        when(playlistServiceMock.modifyPlaylist(any(),anyString(),anyString(),anyList())).thenReturn(playListUpdateResponse);

        commandMock.execute(Arrays.asList("ModifyCommand","ADD-SONG","1","1","2","3"));
        Assertions.assertEquals(playListUpdateResponse.toString(),outputStreamCaptor.toString());
        verify(playlistServiceMock,times(1)).modifyPlaylist(any(),anyString(),anyString(),anyList());
    }

   @Test
    void execute_throwsException() throws NoSuchSongException, PlaylistNotFoundException {
        String output="Some Requested Songs for Deletion are not present in the playlist. Please try again.";

            doThrow(new NoSuchSongException(output)).when(playlistServiceMock).modifyPlaylist(any(),anyString(),anyString(),anyList());
       commandMock.execute(Arrays.asList("ModifyCommand","ADD-SONG","1","1","2","3"));

       Assertions.assertEquals(output,outputStreamCaptor.toString());
   }
}