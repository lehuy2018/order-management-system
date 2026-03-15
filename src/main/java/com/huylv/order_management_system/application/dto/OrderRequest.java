package com.huylv.order_management_system.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(
    @NotBlank String customerName,
    @NotNull Double totalPrice) {
}