package com.huylv.order_management_system.application.order.dto;

public class OrderResponse {

    private Long id;
    private String name;

    public OrderResponse() {}

    public OrderResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
