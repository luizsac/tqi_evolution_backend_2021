package com.tqi.evolution.tqievolution.dto;

import com.tqi.evolution.tqievolution.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class AuthenticatedUserDTO {

    private String name;

    private String username;

    public static AuthenticatedUserDTO toDTO(User user, String email) {
        return new AuthenticatedUserDTO(
                user.getName(),
                user.getEmail()
        );
    }

}
