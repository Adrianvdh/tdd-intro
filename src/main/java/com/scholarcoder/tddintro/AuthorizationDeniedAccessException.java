package com.scholarcoder.tddintro;

public class AuthorizationDeniedAccessException extends RuntimeException {
    public AuthorizationDeniedAccessException(String message) {
        super(message);
    }
}
