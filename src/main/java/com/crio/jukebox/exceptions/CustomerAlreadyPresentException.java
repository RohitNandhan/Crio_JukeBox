package com.crio.jukebox.exceptions;

public class CustomerAlreadyPresentException extends Exception{
    public CustomerAlreadyPresentException(){}
    public CustomerAlreadyPresentException(String msg){
        super(msg);
    }
}
