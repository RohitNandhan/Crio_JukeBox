package com.crio.jukebox.commands;

import com.crio.jukebox.dto.PlayListUpdateResponse;
import com.crio.jukebox.entites.PlayListAction;
import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

import java.util.List;

public class ModifyPlaylistCommand implements ICommand {

   private final IPlaylistService playlistService;

    public ModifyPlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String action=tokensList.get(1);
        String userID=tokensList.get(2);
        String playlistId=tokensList.get(3);
        List<String> songIds=tokensList.subList(4,tokensList.size());
        PlayListUpdateResponse playListUpdateResponse;
        try {
//            if(action=="ADD-SONG"){
//                playListUpdateResponse=  playlistService.modifyPlaylist(PlayListAction.ADD_SONG,userID,playlistId,songIds);
//                System.out.print(playListUpdateResponse);
//        }else if(action=="DELETE-SONG"){
//                playListUpdateResponse= playlistService.modifyPlaylist(PlayListAction.DELETE_SONG,userID,playlistId,songIds);

            playListUpdateResponse=  playlistService.modifyPlaylist(action,userID,playlistId,songIds);
            System.out.print(playListUpdateResponse);


        } catch (NoSuchSongException e) {
            System.out.print(e.getMessage());
        } catch (PlaylistNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }
}
