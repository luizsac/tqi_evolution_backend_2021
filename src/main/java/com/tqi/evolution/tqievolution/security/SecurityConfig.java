package com.tqi.evolution.tqievolution.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    public void setPrefix(String prefix) {
        SecurityConfig.PREFIX = prefix;
    }

    public void setKey(String key) {
        SecurityConfig.KEY = key;
    }

    public void setExpiration(Long expiration) {
        SecurityConfig.EXPIRATION = expiration;
    }
}
