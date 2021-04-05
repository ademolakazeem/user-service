package com.genesys.userservice.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
