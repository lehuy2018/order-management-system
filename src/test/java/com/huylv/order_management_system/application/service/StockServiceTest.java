package com.huylv.order_management_system.application.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {
    @InjectMocks
    private StockService stockService;

    @Test
    void testUpdateStockThrowsRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> stockService.updateStock());
        assertEquals("Stock failed", exception.getMessage());
    }
}
