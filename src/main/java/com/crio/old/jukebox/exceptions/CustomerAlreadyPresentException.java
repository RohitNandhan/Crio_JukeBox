package com.crio.old.jukebox.exceptions;

public class CustomerAlreadyPresentException extends Exception{
    public CustomerAlreadyPresentException(){}
    public CustomerAlreadyPresentException(String msg){
        super(msg);
    }
}
