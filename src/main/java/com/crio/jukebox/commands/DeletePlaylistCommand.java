package com.crio.jukebox.commands;

import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

import java.util.List;

public class DeletePlaylistCommand implements ICommand {
    private final IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String userID=tokensList.get(1);
        String playlistID=tokensList.get(2);
        try{
            if(playlistService.deletePlaylist(userID,playlistID))
                System.out.print("Delete Successful");
        }catch (PlaylistNotFoundException e){
            System.out.print(e.getMessage());
        }
    }
}
