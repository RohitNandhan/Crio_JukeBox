package com.crio.jukebox.exceptions;

public class CommandNotFoundException extends Exception{
    public CommandNotFoundException(){}
    public CommandNotFoundException(String msg){
        super(msg);
    }
}
