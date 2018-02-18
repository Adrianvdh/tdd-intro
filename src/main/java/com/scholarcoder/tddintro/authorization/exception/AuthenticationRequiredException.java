package com.scholarcoder.tddintro.authorization.exception;

public class AuthenticationRequiredException extends RuntimeException {
    public AuthenticationRequiredException(String message) {
        super(message);
    }
}
