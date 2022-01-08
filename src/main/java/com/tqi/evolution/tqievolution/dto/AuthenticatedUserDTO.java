package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import com.tqi.evolution.tqievolution.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @Getter
public class AuthenticatedUserDTO {

    private long user_id;

    private String name;

    private String email;

    private String token;

    List<LoanRequest> loanRequests;

    public static AuthenticatedUserDTO toDTO(User user) {
        return new AuthenticatedUserDTO(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                "*token*",
                user.getLoanRequests()
        );
    }

}
