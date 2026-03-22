package com.huylv.order_management_system.application.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.huylv.order_management_system.application.dto.UserLoginRequest;
import com.huylv.order_management_system.application.dto.UserLoginResponse;
import com.huylv.order_management_system.application.dto.UserRegisterRequest;
import com.huylv.order_management_system.config.security.JwtService;
import com.huylv.order_management_system.domain.model.User;
import com.huylv.order_management_system.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public void register(UserRegisterRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());

        // Mã hóa mật khẩu trước khi lưu
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(request.role());
        userRepository.save(user);
    }

    public UserLoginResponse login(UserLoginRequest request) {
        // Xác thực user (UsernamePasswordAuthenticationToken sẽ gọi CustomUserDetailsService)
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        // Nếu xác thực thành công, sinh token
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(userDetails);
        return new UserLoginResponse(token);
    }
}