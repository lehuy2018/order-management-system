package com.huylv.order_management_system.application.dto;

import com.huylv.order_management_system.domain.enums.OrderStatus;

public class OrderResponse {

    private Long id;
    private String customerName;
    private Double totalPrice;
    private OrderStatus status;

    public OrderResponse(Long id, String customerName, Double totalPrice, OrderStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }
}