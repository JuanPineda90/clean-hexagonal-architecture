package com.paymentchain.consumer.exception;

import com.paymentchain.exception.TechnicalException;

public class ExternalServiceException extends TechnicalException {

    public ExternalServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExternalServiceException(String message) {
        super(message);
    }
}
