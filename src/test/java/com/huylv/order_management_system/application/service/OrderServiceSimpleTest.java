package com.huylv.order_management_system.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.huylv.order_management_system.domain.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceSimpleTest {
    @Mock
    private OrderRepository repository;
    @Mock
    private StockService stockService;
    @InjectMocks
    private OrderService orderService;

    @Test
    void testCreateOrderWithTransactionTest_CatchException() {
        doThrow(new RuntimeException()).when(stockService).updateStock();
        assertDoesNotThrow(() -> orderService.createOrderWithTransactionTest(true));
        verify(repository).save(any());
        verify(stockService).updateStock();
    }

    @Test
    void testCreateOrderWithTransactionTest_ThrowException() {
        doThrow(new RuntimeException()).when(stockService).updateStock();
        assertThrows(RuntimeException.class, () -> orderService.createOrderWithTransactionTest(false));
        verify(repository).save(any());
        verify(stockService).updateStock();
    }
}
