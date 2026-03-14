package com.huylv.order_management_system.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.application.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return service.getAllOrders();
    }

    @GetMapping("/page")
    public Page<OrderResponse> getOrders(int page, int size) {
        return service.getOrders(page, size);
    }

    @PostMapping
    public OrderResponse create(@NonNull @RequestBody OrderRequest order) {
        return service.createOrder(order);
    }
}