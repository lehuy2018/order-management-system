package com.huylv.order_management_system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.huylv.order_management_system.application.service.OrderService;
import com.huylv.order_management_system.domain.repository.OrderRepository;

@SpringBootTest
class TransactionTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository repository;

    @Test
    void test_requires_new_catch() {
        orderService.createOrder(true);

        System.out.println("Count: " + repository.count());
    }

    @Test
    void test_requires_new_throw() {
        try {
            orderService.createOrder(false);
        } catch (Exception ignored) {}

        System.out.println("Count: " + repository.count());
    }
}