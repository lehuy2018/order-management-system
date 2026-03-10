package com.huylv.order_management_system.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTest {

    @Test
    void updateStock_throwsRuntimeException() {
        StockService stockService = new StockService();
        assertThrows(RuntimeException.class, stockService::updateStock);
    }
}
