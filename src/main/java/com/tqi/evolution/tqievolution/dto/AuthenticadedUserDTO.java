package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.LoanRequest;

import java.util.List;

public class AuthenticadedUserDTO {

    private long user_id;

    private String name;

    private String email;

    private String token;

    List<LoanRequest> loanRequests;

}
