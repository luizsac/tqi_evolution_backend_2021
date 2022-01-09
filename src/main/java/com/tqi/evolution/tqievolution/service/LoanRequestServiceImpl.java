package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.exception.LoanRequestNotFoundException;
import com.tqi.evolution.tqievolution.repository.LoanRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;

    @Override
    public LoanRequest create(LoanRequest loanRequest) throws InvalidLoanRequestParametersException {
        if (loanRequest.getFirstInstallmentDt().isAfter(LocalDate.now().plusMonths(3))
                || loanRequest.getNumberOfInstallments() > 60) {
            throw new InvalidLoanRequestParametersException();
        }

        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public LoanRequest getLoanRequestById(long id) throws LoanRequestNotFoundException {
        return loanRequestRepository.findById(id).orElseThrow(LoanRequestNotFoundException::new);
    }

    @Override
    public List<LoanRequest> getLoanRequestsByUserId(long id) {
        return loanRequestRepository.findByUserId(id);
    }
}
