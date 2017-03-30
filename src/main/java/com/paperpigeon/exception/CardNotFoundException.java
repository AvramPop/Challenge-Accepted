package com.paperpigeon.exception;

/**
 * Created by dani on 3/14/17.
 */
public class CardNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public CardNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public CardNotFoundException() {
        super();
    }
}
