package com.huylv.order_management_system.application.dto;

import jakarta.validation.constraints.NotBlank;

public record UserLoginRequest(
    @NotBlank String username,
    @NotBlank String password) {
}