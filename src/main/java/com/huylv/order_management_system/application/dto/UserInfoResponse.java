package com.huylv.order_management_system.application.dto;

public record UserInfoResponse(
    String username,
    String email,
    String roles) {
}
