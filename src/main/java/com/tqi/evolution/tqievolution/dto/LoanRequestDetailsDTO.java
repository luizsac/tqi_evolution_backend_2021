package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor @Getter
public class LoanRequestDetailsDTO {

    private long requestId;
    private BigDecimal amount;
    private int numberOfInstallments;
    private LocalDate firstInstallmentDt;
    private String userEmail;
    private BigDecimal userIncome;

    public static LoanRequestDetailsDTO toDTO(LoanRequest loanRequest) {
        return new LoanRequestDetailsDTO(
                loanRequest.getRequestId(),
                loanRequest.getAmount(),
                loanRequest.getNumberOfInstallments(),
                loanRequest.getFirstInstallmentDt(),
                loanRequest.getUser().getEmail(),
                loanRequest.getUser().getIncome()
        );
    }

}
