package com.sandesh.security.filter;

public class JwtTokenInvalid extends RuntimeException{

    public JwtTokenInvalid(String message) {
        super(message);
    }
}
