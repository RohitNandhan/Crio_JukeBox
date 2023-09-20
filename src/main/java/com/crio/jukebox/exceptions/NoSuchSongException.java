package com.crio.jukebox.exceptions;

public class NoSuchSongException extends Exception{
    public NoSuchSongException(){}
    public NoSuchSongException(String msg){
        super(msg);
    }
}
