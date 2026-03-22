package com.huylv.order_management_system.application.dto;

import com.huylv.order_management_system.domain.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterRequest(
    @NotBlank String username,
    @NotBlank String email,
    @NotBlank String password,
    @NotNull Role role
) {
}