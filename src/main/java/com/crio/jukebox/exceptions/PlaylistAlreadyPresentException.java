package com.crio.jukebox.exceptions;

public class PlaylistAlreadyPresentException extends Exception{
    public PlaylistAlreadyPresentException(){}
    public PlaylistAlreadyPresentException(String msg){
        super(msg);
    }
}
