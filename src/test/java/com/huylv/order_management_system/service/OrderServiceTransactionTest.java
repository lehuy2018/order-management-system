package com.huylv.order_management_system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.huylv.order_management_system.application.service.OrderService;
import com.huylv.order_management_system.domain.repository.OrderRepository;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceTransactionTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void shouldRollbackTransactionWhenException() {

        assertThrows(RuntimeException.class, () -> {
            orderService.createOrder(null);
        });

        long count = orderRepository.count();

        assertEquals(0, count);
    }
}