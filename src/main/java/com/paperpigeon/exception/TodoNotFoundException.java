package com.paperpigeon.exception;

/**
 * Created by dani on 2/8/17.
 */
public class TodoNotFoundException extends Exception {
    public TodoNotFoundException(String message){
        super(message);
    }

    public TodoNotFoundException(){
        super();
    }
}
