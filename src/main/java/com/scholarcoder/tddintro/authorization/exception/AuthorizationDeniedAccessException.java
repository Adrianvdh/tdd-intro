package com.scholarcoder.tddintro.authorization.exception;

public class AuthorizationDeniedAccessException extends RuntimeException {
    public AuthorizationDeniedAccessException(String message) {
        super(message);
    }
}
