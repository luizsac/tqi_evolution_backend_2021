package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.exception.LoanRequestNotFoundException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;

import java.util.List;

public interface LoanRequestService {

    LoanRequest create(String token, LoanRequest loanRequest) throws InvalidLoanRequestParametersException, UserNotFoundException;
    List<LoanRequest> getLoanRequestsByUsername(String token);
    LoanRequest getLoanRequestById(long id) throws LoanRequestNotFoundException;

}
