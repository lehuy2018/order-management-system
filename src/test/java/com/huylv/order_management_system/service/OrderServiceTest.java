package com.huylv.order_management_system.service;

import com.huylv.order_management_system.entity.OrderEntity;
import com.huylv.order_management_system.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private StockService stockService;

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderRepository, stockService);
    }

    @Test
    void createOrder_catchException_savesOrderAndCatchesStockException() {
        doThrow(new RuntimeException("Stock failed")).when(stockService).updateStock();
        when(orderRepository.save(any(OrderEntity.class))).thenReturn(new OrderEntity("ORDER-1"));

        assertDoesNotThrow(() -> orderService.createOrder(true));

        verify(orderRepository).save(any(OrderEntity.class));
        verify(stockService).updateStock();
    }

    @Test
    void createOrder_noExceptionCatch_savesOrderAndPropagatesException() {
        doThrow(new RuntimeException("Stock failed")).when(stockService).updateStock();
        when(orderRepository.save(any(OrderEntity.class))).thenReturn(new OrderEntity("ORDER-1"));

        assertThrows(RuntimeException.class, () -> orderService.createOrder(false));

        verify(orderRepository).save(any(OrderEntity.class));
        verify(stockService).updateStock();
    }

    @Test
    void createOrder_stockSucceeds_savesOrder() {
        when(orderRepository.save(any(OrderEntity.class))).thenReturn(new OrderEntity("ORDER-1"));

        assertDoesNotThrow(() -> orderService.createOrder(true));

        verify(orderRepository).save(any(OrderEntity.class));
        verify(stockService).updateStock();
    }
}
