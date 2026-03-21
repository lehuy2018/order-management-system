package com.huylv.order_management_system.application.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequest(
    @NotBlank String username,
    @NotBlank String email,
    @NotBlank String password) {
}