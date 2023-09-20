package com.crio.jukebox.exceptions;

public class SongDuplicationException extends Exception{
    public SongDuplicationException(){}
    public SongDuplicationException(String msg){
        super(msg);
    }
}
