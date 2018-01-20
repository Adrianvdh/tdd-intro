package com.scholarcoder.tddintro;

public class AuthorizationRequiredException extends RuntimeException {
    public AuthorizationRequiredException(String message) {
        super(message);
    }
}
