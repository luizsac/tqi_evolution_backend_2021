package com.tqi.evolution.tqievolution.service;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.entity.User;
import com.tqi.evolution.tqievolution.exception.InvalidLoanRequestParametersException;
import com.tqi.evolution.tqievolution.exception.LoanRequestNotFoundException;
import com.tqi.evolution.tqievolution.exception.UserNotFoundException;
import com.tqi.evolution.tqievolution.repository.LoanRequestRepository;
import com.tqi.evolution.tqievolution.repository.UserRepository;
import com.tqi.evolution.tqievolution.security.JWTCreator;
import com.tqi.evolution.tqievolution.security.JWTObject;
import com.tqi.evolution.tqievolution.security.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;
    private SecurityConfig securityConfig;

    @Override
    public LoanRequest create(String token, LoanRequest loanRequest)
            throws InvalidLoanRequestParametersException, UserNotFoundException {
        if (loanRequest.getFirstInstallmentDt().isAfter(LocalDate.now().plusMonths(3))
                || loanRequest.getNumberOfInstallments() > 60) {
            throw new InvalidLoanRequestParametersException();
        }

        JWTObject jwtObject = JWTCreator.create(token, SecurityConfig.PREFIX, SecurityConfig.KEY);
        User user = userRepository.findByEmail(jwtObject.getSubject()).orElseThrow(UserNotFoundException::new);
        loanRequest.setUser(user);

        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public List<LoanRequest> getLoanRequestsByUsername(String token) {
        JWTObject jwtObject = JWTCreator.create(token, SecurityConfig.PREFIX, SecurityConfig.KEY);

        return loanRequestRepository.findByUserUsername(jwtObject.getSubject());
    }

    @Override
    public LoanRequest getLoanRequestById(long id) throws LoanRequestNotFoundException {
        return loanRequestRepository.findById(id).orElseThrow(LoanRequestNotFoundException::new);
    }

}
