package com.avengers.gamera.exception;


public class ResourceExistException extends RuntimeException {

    public ResourceExistException() {
        super("Resource already exists!");
    }

    public ResourceExistException(String msg) {
        super(msg);
    }
}
