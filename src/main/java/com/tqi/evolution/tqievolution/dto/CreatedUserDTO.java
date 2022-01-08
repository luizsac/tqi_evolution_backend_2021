package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor @Getter
public class CreatedUserDTO {

    private long user_id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String address;
    private BigDecimal income;

    public static CreatedUserDTO toDto(User user) {
        return new CreatedUserDTO(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getRg(),
                user.getAddress(),
                user.getIncome()
        );
    }
}
