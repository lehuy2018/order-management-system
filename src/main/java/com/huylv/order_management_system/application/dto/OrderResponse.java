package com.huylv.order_management_system.application.dto;

public class OrderResponse {

    private Long id;
    private String customerName;
    private Double totalPrice;

    public OrderResponse(Long id, String customerName, Double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
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
}