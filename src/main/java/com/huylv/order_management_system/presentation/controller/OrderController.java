package com.huylv.order_management_system.presentation.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.application.dto.OrderSummaryResponse;
import com.huylv.order_management_system.application.dto.UpdateOrderRequest;
import com.huylv.order_management_system.application.service.OrderAsyncService;
import com.huylv.order_management_system.application.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;
    private final OrderAsyncService orderAsyncService;

    public OrderController(OrderService service, OrderAsyncService orderAsyncService) {
        this.service = service;
        this.orderAsyncService = orderAsyncService;
    }

    @GetMapping
    public ResponseEntity<Page<OrderResponse>> getOrders(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.getOrders(page, size));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create( 
        @NonNull @Valid @RequestBody OrderRequest order) {
        return ResponseEntity.ok(service.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update( 
        @NonNull @PathVariable Long id,
        @NonNull @Valid @RequestBody UpdateOrderRequest order) {
        return ResponseEntity.ok(service.updateOrder(id, order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(
        @NonNull @Valid @PathVariable Long id) {
        System.out.println("👉 Hit DB");
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @GetMapping("/summary")
    public ResponseEntity<OrderSummaryResponse> getSummary() {

        long start = System.currentTimeMillis();

        CompletableFuture<Integer> totalOrdersFuture =
                orderAsyncService.countOrders();

        CompletableFuture<Long> revenueFuture =
                orderAsyncService.calculateRevenue();

        // Đợi tất cả task xong
        CompletableFuture.allOf(totalOrdersFuture, revenueFuture).join();

        // Lấy kết quả
        int totalOrders = totalOrdersFuture.join();
        long totalRevenue = revenueFuture.join();

        long end = System.currentTimeMillis();
        System.out.println("Total Time: " + (end - start));

        return ResponseEntity.ok(new OrderSummaryResponse(totalOrders, totalRevenue));
    }
}