package com.huylv.order_management_system.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huylv.order_management_system.application.dto.UserInfoResponse;
import com.huylv.order_management_system.application.dto.UserLoginRequest;
import com.huylv.order_management_system.application.dto.UserLoginResponse;
import com.huylv.order_management_system.application.dto.UserRegisterRequest;
import com.huylv.order_management_system.domain.model.User;
import com.huylv.order_management_system.domain.repository.UserRepository;
import com.huylv.order_management_system.application.service.AccountService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final UserRepository userRepository;
    private final AccountService accountService;

    @GetMapping("/by-email")
    public ResponseEntity<UserInfoResponse> getUserInfoByEmail(@RequestParam @Valid @NotBlank String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        // Giả sử user có phương thức getRoles() hoặc hardcode tạm thời để khớp với DTO
        return ResponseEntity.ok(new UserInfoResponse(user.getUsername(), user.getEmail(), "ROLE_USER"));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserRegisterRequest request) {
        accountService.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody @Valid UserLoginRequest request) {
        return ResponseEntity.ok(accountService.login(request));
    }
}
