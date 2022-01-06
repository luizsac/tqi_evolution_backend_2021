package com.tqi.evolution.tqievolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    public UserNotFoundException(long id) {
        super(String.format("User with id %s was not found in the database", id));
    }

}
