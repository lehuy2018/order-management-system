package com.huylv.order_management_system.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class StockService {

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = RuntimeException.class)
    public void updateStock() {
        log.info("Inner TX active: {}", TransactionSynchronizationManager.isActualTransactionActive());
        throw new RuntimeException("Stock failed");
    }
}