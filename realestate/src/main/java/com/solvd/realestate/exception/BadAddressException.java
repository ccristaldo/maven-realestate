package com.solvd.realestate.exception;

public class BadAddressException extends Exception{
    public BadAddressException() {}

    public BadAddressException(String msg) {
        super(msg);
    }
}
