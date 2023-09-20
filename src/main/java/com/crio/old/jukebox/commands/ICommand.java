package com.crio.old.jukebox.commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokensList);
}
