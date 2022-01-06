package com.tqi.evolution.tqievolution.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class LoginDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
