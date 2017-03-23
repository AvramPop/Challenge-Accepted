package com.paperpigeon.exception;

/**
 * Created by dani on 2/8/17.
 */
public class ObjectAlreadyInDB extends Exception {
    public ObjectAlreadyInDB(String objectClass){
        super("This object of type " + objectClass + " is already in the DB");
    }

    public ObjectAlreadyInDB(){
        super();
    }
}
