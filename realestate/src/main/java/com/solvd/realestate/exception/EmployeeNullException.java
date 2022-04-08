package com.solvd.realestate.exception;

public class EmployeeNullException extends RuntimeException{
    public EmployeeNullException() {}

    public EmployeeNullException(String msg) {
        super(msg);
    }
}
