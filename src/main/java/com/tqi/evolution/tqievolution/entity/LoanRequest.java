package com.tqi.evolution.tqievolution.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "loan_request")
@NoArgsConstructor @Getter @Setter @ToString
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "first_installment_dt", nullable = false)
    private LocalDate firstInstallmentDt;

    @Column(name = "number_of_installments", nullable = false)
    private int numberOfInstallments;

    public LoanRequest(BigDecimal amount, LocalDate firstInstallmentDt, int numberOfInstallments) {
        this.amount = amount;
        this.firstInstallmentDt = firstInstallmentDt;
        this.numberOfInstallments = numberOfInstallments;
    }

}
