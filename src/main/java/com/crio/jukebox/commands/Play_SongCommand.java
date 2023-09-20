package com.crio.jukebox.commands;

import com.crio.jukebox.dto.PlayResponse;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.services.IPlayPlaylistService;

import java.util.List;

public class Play_SongCommand implements ICommand{
    private final IPlayPlaylistService playPlaylistService;

    public Play_SongCommand(IPlayPlaylistService playPlaylistService) {
        this.playPlaylistService = playPlaylistService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String userId=tokensList.get(1);
        String action=tokensList.get(2);

        try {
          PlayResponse playResponse= playPlaylistService.playSong(userId,action);
            System.out.print(playResponse);
        } catch (NoSuchSongException e) {
            System.out.print(e.getMessage());
        }
    }
}
