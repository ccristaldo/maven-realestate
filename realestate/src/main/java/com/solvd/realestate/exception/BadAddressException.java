package com.solvd.realestate.exception;

public class BadAddressException extends RuntimeException{
    public BadAddressException() {}

    public BadAddressException(String msg) {
        super(msg);
    }
}
