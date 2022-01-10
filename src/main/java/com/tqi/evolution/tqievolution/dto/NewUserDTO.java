package com.tqi.evolution.tqievolution.dto;

import com.sun.istack.NotNull;
import com.tqi.evolution.tqievolution.entity.User;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class NewUserDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String cpf;

    private String rg;

    @NotNull
    private String address;

    @NotNull
    private BigDecimal income;

    @NotNull
    private String password;

    @NotNull
    private List<String> roles;

    public User toUser() {
        return new User(
                this.name,
                this.email,
                this.cpf,
                this.rg,
                this.address,
                this.income,
                this.password,
                this.roles
        );
    }

}
