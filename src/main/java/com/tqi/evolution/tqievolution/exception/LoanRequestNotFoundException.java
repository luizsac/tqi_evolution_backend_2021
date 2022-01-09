package com.tqi.evolution.tqievolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanRequestNotFoundException extends Exception {

    public LoanRequestNotFoundException() {
        super("Loan Request was not found in the database");
    }

}
