package com.huylv.order_management_system.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.application.jwt")
public class JwtProperties {

    private String secret;
    private long expiration;

}