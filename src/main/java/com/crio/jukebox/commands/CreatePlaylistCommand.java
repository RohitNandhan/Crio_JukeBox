package com.crio.jukebox.commands;

import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.services.IPlaylistService;

import java.util.List;

public class CreatePlaylistCommand implements ICommand {
    String userId;
    String playlistName;
    List<String> songsId;

    private final IPlaylistService playlistService;

    public CreatePlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokensList) {
         userId=tokensList.get(1);
         playlistName=tokensList.get(2);
         songsId=tokensList.subList(3,tokensList.size());

         try {
           String playlistId= playlistService.createPlaylist(userId,playlistName,songsId);
             System.out.print("Playlist ID - "+playlistId);
         }catch (NoSuchSongException e){
             System.out.println(e.getMessage());
         }
    }
}
