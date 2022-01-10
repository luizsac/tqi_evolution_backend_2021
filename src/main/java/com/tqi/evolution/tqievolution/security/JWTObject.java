package com.tqi.evolution.tqievolution.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class JWTObject {

    private String subject;
    private Date issuedAt;
    private Date expiration;
    private List<String> roles;

}
