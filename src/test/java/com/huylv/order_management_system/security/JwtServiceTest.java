package com.huylv.order_management_system.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.huylv.order_management_system.config.security.JwtProperties;
import com.huylv.order_management_system.config.security.JwtService;

@ExtendWith(MockitoExtension.class)
class JwtServiceTest {

    private JwtService jwtService;

    @Mock
    private JwtProperties properties;

    @BeforeEach
    void setUp() {
        // Mock JwtProperties với secret key hợp lệ (Base64 encoded, > 256 bits)
        // Chuỗi dưới decode ra > 32 bytes
        String secret = "VGhpc0lzQVNlY3JldEtleUZvclRlc3RpbmdKd3RTZXJ2aWNlMjU2Yml0"; 
        when(properties.getSecret()).thenReturn(secret);
        when(properties.getExpiration()).thenReturn(86400000L); // 24 giờ

        jwtService = new JwtService(properties);
    }

    @Test
    void testGenerateAndValidateToken() {
        // 1. Tạo dummy user (không cần DB)
        UserDetails user = new User("testuser", "password", List.of(new SimpleGrantedAuthority("ROLE_USER")));

        // 2. Tạo token
        String token = jwtService.generateToken(user);
        assertNotNull(token);
        System.out.println("Generated Token: " + token);

        // 3. Validate token
        assertTrue(jwtService.isTokenValid(token, user));

        // 4. Extract username
        assertEquals("testuser", jwtService.extractUsername(token));
    }
}
