package com.crio.jukebox.commands;

import com.crio.jukebox.entites.User;
import com.crio.jukebox.services.IUserService;

import java.util.List;

public class CreateUserCommand implements ICommand {
    private final IUserService userService;

    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokensList) {
        String input=tokensList.get(1);
        User createdUser=userService.createUser(input);
        System.out.print(createdUser.getId()+" "+createdUser.getName());
    }
}
