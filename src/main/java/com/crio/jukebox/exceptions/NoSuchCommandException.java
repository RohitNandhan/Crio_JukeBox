package com.crio.jukebox.exceptions;

public class NoSuchCommandException extends Exception{
    public NoSuchCommandException(){}
    public NoSuchCommandException(String msg){
        super(msg);
    }
}
