package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.repository.LoanRequestRepository;
import com.tqi.evolution.tqievolution.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;

    @Override
    public LoanRequest create(LoanRequest loanRequest) throws InvalidLoanRequestParametersException {
        if (loanRequest.getFirstInstallmentDt().isAfter(LocalDate.now().plusMonths(3))
                || loanRequest.getNumberOfInstallments() > 60) {
            throw new InvalidLoanRequestParametersException();
        }

        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public LoanRequest getLoanRequestById(long id) {
        return null;
    }
}
