package com.huylv.order_management_system.application.dto;

import java.util.List;

import com.huylv.order_management_system.domain.enums.OrderStatus;

public class OrderResponse {

    private Long id;
    private String customerName;
    private Double totalPrice;
    private OrderStatus status;
    private List<OrderItemResponse> items;

    public OrderResponse(Long id, String customerName, Double totalPrice, OrderStatus status, List<OrderItemResponse> items) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.items = items;
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

    public List<OrderItemResponse> getItems() {
        return items;
    }
}