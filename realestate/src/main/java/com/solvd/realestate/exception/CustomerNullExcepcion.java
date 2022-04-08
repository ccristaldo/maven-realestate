package com.solvd.realestate.exception;

public class CustomerNullExcepcion extends RuntimeException{
    public CustomerNullExcepcion() {}

    public CustomerNullExcepcion(String msg) {
        super(msg);
    }
}
