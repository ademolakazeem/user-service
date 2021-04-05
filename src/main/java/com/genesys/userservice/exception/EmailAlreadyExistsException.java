package com.genesys.userservice.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
