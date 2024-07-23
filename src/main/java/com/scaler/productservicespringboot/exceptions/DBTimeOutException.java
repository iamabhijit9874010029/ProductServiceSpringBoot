package com.scaler.productservicespringboot.exceptions;

public class DBTimeOutException extends Exception {
    public DBTimeOutException(String message) {
        super(message);
    }
}
