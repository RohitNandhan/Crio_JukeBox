package com.crio.jukebox.commands;


import com.crio.jukebox.services.ISongService;

import java.util.List;

public class LoadDataCommand implements ICommand {
  private final ISongService songService;

    public LoadDataCommand(ISongService songService) {
        this.songService = songService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String filePath=tokensList.get(1);
        String out=songService.loadSongFromFile(filePath);
        System.out.print(out);
    }
}
