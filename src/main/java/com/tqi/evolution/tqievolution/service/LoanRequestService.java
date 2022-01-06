package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;

import java.util.Optional;

public interface LoanRequestService {

    Optional<LoanRequest> create(LoanRequest loanRequest);



}
