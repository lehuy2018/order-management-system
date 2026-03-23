package com.huylv.order_management_system.application.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huylv.order_management_system.application.dto.UserInfoResponse;
import com.huylv.order_management_system.application.dto.UserLoginRequest;
import com.huylv.order_management_system.application.dto.UserLoginResponse;
import com.huylv.order_management_system.application.dto.UserRegisterRequest;
import com.huylv.order_management_system.config.security.JwtService;
import com.huylv.order_management_system.domain.model.User;
import com.huylv.order_management_system.domain.repository.UserRepository;
import com.huylv.order_management_system.exception.DuplicateResourceException;
import com.huylv.order_management_system.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Transactional
    public void register(UserRegisterRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new DuplicateResourceException("Email already exists");
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
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Nếu xác thực thành công, sinh token
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(userDetails);
        return new UserLoginResponse(token);
    }

    public UserInfoResponse getUserInfoByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found by email"));

        // Giả sử user có phương thức getRoles() hoặc hardcode tạm thời để khớp với DTO
        return new UserInfoResponse(user.getUsername(), user.getEmail(), "ROLE_USER");
    }
}