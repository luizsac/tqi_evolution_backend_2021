package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor @Getter
public class LoanRequestDTO {

    private long requestId;
    private BigDecimal amount;
    private LocalDate firstInstallmentDt;
    private int numberOfInstallments;

    public static LoanRequestDTO toDTO(LoanRequest loanRequest) {
        return new LoanRequestDTO(
                loanRequest.getRequestId(),
                loanRequest.getAmount(),
                loanRequest.getFirstInstallmentDt(),
                loanRequest.getNumberOfInstallments()
        );
    }

}
