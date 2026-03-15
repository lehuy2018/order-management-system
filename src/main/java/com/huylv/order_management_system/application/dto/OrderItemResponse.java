package com.huylv.order_management_system.application.dto;

import com.huylv.order_management_system.domain.model.OrderItem;

public record OrderItemResponse(
    Long id,
    String productName,
    Integer quantity,
    Double price) {

    public static OrderItemResponse fromEntity(OrderItem item) {
        return new OrderItemResponse(item.getId(), item.getProductName(), item.getQuantity(), item.getPrice());
    }
}
