package com.scaler.productservicespringboot.exceptions;

public class DBNotFoundException extends Exception{
    public DBNotFoundException(String message){
        super(message);
    }
}
