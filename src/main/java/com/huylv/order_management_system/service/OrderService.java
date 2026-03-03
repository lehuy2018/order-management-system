package com.huylv.order_management_system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.huylv.order_management_system.entity.OrderEntity;
import com.huylv.order_management_system.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final StockService stockService;

    @Transactional
    public void createOrder(boolean catchException) {

        System.out.println("Outer TX active: " +
                TransactionSynchronizationManager.isActualTransactionActive());

        repository.save(new OrderEntity("ORDER-1"));

        if (catchException) {
            try {
                stockService.updateStock();
            } catch (Exception e) {
                System.out.println("Caught exception");
            }
        } else {
            stockService.updateStock();
        }
    }
}