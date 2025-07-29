package com.paymentchain.jpa.exception;


import com.paymentchain.exception.TechnicalException;

public class DatabaseAccessException extends TechnicalException {

    public DatabaseAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}