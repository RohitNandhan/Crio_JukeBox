package com.crio.jukebox.exceptions;

public class PlaylistNotFoundException extends Exception{
    public PlaylistNotFoundException(){}
    public PlaylistNotFoundException(String msg){
        super(msg);
    }
}
