package com.tqi.evolution.tqievolution.dto;

import com.sun.istack.NotNull;
import com.tqi.evolution.tqievolution.entity.User;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

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

    public User toUser() {
        return new User(
                this.name,
                this.email,
                this.cpf,
                this.rg,
                this.address,
                this.income,
                this.password
        );
    }

}
