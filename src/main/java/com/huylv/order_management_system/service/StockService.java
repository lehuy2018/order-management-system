package com.huylv.order_management_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Service
public class StockService {

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = RuntimeException.class)
    public void updateStock() {
        System.out.println("Inner TX active: " +
                TransactionSynchronizationManager.isActualTransactionActive());

        throw new RuntimeException("Stock failed");
    }
}