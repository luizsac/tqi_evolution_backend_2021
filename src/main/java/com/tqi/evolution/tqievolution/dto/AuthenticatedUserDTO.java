package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class AuthenticatedUserDTO {

    private String name;

    private String username;

    private String token;

    public static AuthenticatedUserDTO toDTO(User user, String token) {
        return new AuthenticatedUserDTO(
                user.getName(),
                user.getEmail(),
                token
        );
    }

}
