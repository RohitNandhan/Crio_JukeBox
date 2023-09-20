package com.crio.jukebox.commands;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotExistException;
import com.crio.jukebox.services.IPlayPlaylistService;

import java.util.List;

public class Play_PlaylistCommand implements ICommand{
    private final IPlayPlaylistService playPlaylistService;

    public Play_PlaylistCommand(IPlayPlaylistService playPlaylistService) {
        this.playPlaylistService = playPlaylistService;
    }


    @Override
    public void execute(List<String> tokensList) {
        String userId=tokensList.get(1);
        String playlistId=tokensList.get(2);

        try {
          PlayResponse playResponse=playPlaylistService.playPlaylist(userId,playlistId);
            System.out.print(playResponse);
        } catch (SongNotExistException e) {
            System.out.print(e.getMessage());
        }catch (PlaylistNotFoundException e) {
            System.out.print(e.getMessage());
        }

    }
}
