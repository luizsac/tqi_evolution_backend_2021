package com.tqi.evolution.tqievolution.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class LoginDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
