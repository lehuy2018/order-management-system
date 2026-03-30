package com.huylv.order_management_system.application.dto;

import com.huylv.order_management_system.domain.enums.OrderStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderRequest(
    @NotNull Long id,
    @NotBlank OrderStatus status,
    @NotBlank String customerName,
    @NotNull Double totalPrice) {
}