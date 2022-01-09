package com.tqi.evolution.tqievolution.dto;

import com.sun.istack.NotNull;
import com.tqi.evolution.tqievolution.entity.LoanRequest;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class NewLoanRequestDTO {

    @NotNull
    private BigDecimal amount;
    
    @NotNull
    private LocalDate firstInstallmentDt;

    @NotNull
    private int numberOfInstallments;

    public LoanRequest toLoanRequest() {
        return new LoanRequest(
                this.amount,
                this.firstInstallmentDt,
                this.numberOfInstallments
        );
    }

}
