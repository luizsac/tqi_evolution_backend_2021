package com.tqi.evolution.tqievolution.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "loan_request")
public class LoanRequest {

    @Id
    @GeneratedValue
    private long request_id;

    @ManyToOne
    //@JoinColumn(name = "user", referencedColumnName = "user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "first_installment_dt", nullable = false)
    private Date firstInstallmentDt;

    @Column(name = "number_of_installments", nullable = false)
    private int numberOfInstallments;

}
