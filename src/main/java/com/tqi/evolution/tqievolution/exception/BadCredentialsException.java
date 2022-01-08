package com.tqi.evolution.tqievolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadCredentialsException extends Exception {

    public BadCredentialsException() {
        super("Requested User was not found in the database");
    }

}
