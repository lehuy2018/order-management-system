package com.huylv.order_management_system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.application.service.OrderService;
import com.huylv.order_management_system.domain.enums.OrderStatus;
import com.huylv.order_management_system.domain.model.OrderEntity;
import com.huylv.order_management_system.domain.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @SuppressWarnings("null")
    @Test
    void shouldCreateOrderSuccessfully() {

        OrderEntity mockOrder = new OrderEntity();
        mockOrder.setStatus(OrderStatus.PENDING);

        when(orderRepository.save(any(OrderEntity.class)))
                .thenReturn(mockOrder);

        OrderResponse result = orderService.createOrder(new OrderRequest("John Doe", 100.0));

        assertNotNull(result);
        assertEquals(OrderStatus.PENDING, result.getStatus());

        verify(orderRepository).save(any(OrderEntity.class));
    }
}