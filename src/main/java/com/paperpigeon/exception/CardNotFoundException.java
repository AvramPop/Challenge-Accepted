package com.paperpigeon.exception;

/**
 * Created by dani on 3/14/17.
 */
public class CardNotFoundException extends Exception {
    public CardNotFoundException(String message){
        super(message);
    }

    public CardNotFoundException(){
        super();
    }
}
