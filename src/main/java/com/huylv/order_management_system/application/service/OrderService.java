package com.huylv.order_management_system.application.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.domain.model.OrderEntity;
import com.huylv.order_management_system.domain.repository.OrderRepository;

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

        repository.save(new OrderEntity("ORDER-1", 100.0));

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

    @Transactional
    public void outerTest() {
        System.out.println("Outer method");
        innerTest(); // self-invocation
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void innerTest() {
        System.out.println("Inner method - transactional");
        System.out.println(
                "Transaction active: " +
                        TransactionSynchronizationManager.isActualTransactionActive());
    }

    public List<OrderResponse> getAllOrders() {

        return repository.findAll()
                .stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getCustomerName(),
                        order.getTotalPrice()))
                .toList();
    }

    public OrderResponse createOrder(@NonNull OrderRequest order) {
        OrderEntity entity = new OrderEntity();
        order.setCustomerName(order.getCustomerName());
        order.setTotalPrice(order.getTotalPrice());

        OrderEntity saved = repository.save(entity);

        return new OrderResponse(
                saved.getId(),
                saved.getCustomerName(),
                saved.getTotalPrice());
    }
}