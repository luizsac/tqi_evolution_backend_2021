package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;

import java.util.Optional;

public interface LoanRequestService {

    LoanRequest create(LoanRequest loanRequest) throws InvalidLoanRequestParametersException;
    LoanRequest getLoanRequestById(long id);
}
