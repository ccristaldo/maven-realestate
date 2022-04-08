package com.solvd.realestate.exception;

public class NameNullException extends RuntimeException{

    public NameNullException() {}

    public NameNullException(String msg) {
        super(msg);
    }
}
