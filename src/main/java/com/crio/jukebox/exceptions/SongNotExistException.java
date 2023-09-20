package com.crio.jukebox.exceptions;

public class SongNotExistException extends Exception{
    public SongNotExistException(){}
    public SongNotExistException(String msg){
        super(msg);
    }
}
