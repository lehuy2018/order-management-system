package com.huylv.order_management_system.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.application.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public Page<OrderResponse> getOrders(int page, int size) {
        return service.getOrders(page, size);
    }

    @PostMapping
    public OrderResponse create(@NonNull @RequestBody OrderRequest order) {
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(
        @NonNull @Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }
}