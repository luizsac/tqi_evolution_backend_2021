package com.tqi.evolution.tqievolution.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "loan_request")
@NoArgsConstructor @EqualsAndHashCode @Getter @Setter @ToString
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

}
