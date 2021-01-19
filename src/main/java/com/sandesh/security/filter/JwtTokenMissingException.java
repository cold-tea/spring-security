package com.sandesh.security.filter;

public class JwtTokenMissingException extends RuntimeException {

    public JwtTokenMissingException(String message) {
        super(message);
    }
}
