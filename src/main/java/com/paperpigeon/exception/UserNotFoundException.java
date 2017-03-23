package com.paperpigeon.exception;

/**
 * Created by dani on 3/14/17.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(){
        super();
    }
}
