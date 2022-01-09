package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.exception.LoanRequestNotFoundException;

import java.util.List;

public interface LoanRequestService {

    LoanRequest create(LoanRequest loanRequest) throws InvalidLoanRequestParametersException;
    LoanRequest getLoanRequestById(long id) throws LoanRequestNotFoundException;
    List<LoanRequest> getLoanRequestsByUserId(long id);
}
