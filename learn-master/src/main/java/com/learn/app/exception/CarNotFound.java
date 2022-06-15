package com.learn.app.exception;

public class CarNotFound extends Exception {
    private String id;
    private String message;


    public CarNotFound(String id,String message, Exception cause) {
        super(message, cause);
        this.id = id;
        this.message = message;
    }
}
