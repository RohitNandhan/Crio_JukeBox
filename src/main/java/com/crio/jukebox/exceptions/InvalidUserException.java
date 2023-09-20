package com.crio.jukebox.exceptions;

public class InvalidUserException extends Exception{
    public InvalidUserException(){}
    public InvalidUserException(String msg){
        super(msg);
    }
}
