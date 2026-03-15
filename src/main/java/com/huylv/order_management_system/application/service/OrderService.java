package com.huylv.order_management_system.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.application.mapper.OrderMapper;
import com.huylv.order_management_system.domain.enums.OrderStatus;
import com.huylv.order_management_system.domain.model.OrderEntity;
import com.huylv.order_management_system.domain.model.OrderItem;
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

    @Transactional
    public OrderResponse createOrder(@NonNull OrderRequest order) {
        OrderEntity entity = OrderMapper.toEntity(order);
        OrderItem item = new OrderItem();
        item.setProductName("Product 1");
        item.setQuantity(1);
        item.setPrice(10.0);
        entity.addItem(item);
        entity.setStatus(OrderStatus.PENDING);
        return OrderMapper.toResponse(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public Page<OrderResponse> getOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<OrderEntity> orders = repository.findAll(pageable);
        return orders.map(OrderMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public Page<OrderEntity> getOrdersByStatus(
            OrderStatus status,
            int page,
            int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        return repository.findByStatus(status, pageable);
    }

    /**
     * Lấy thông tin đơn hàng theo ID
     * Chỗ này nếu không sử dụng @Transactionnal sẽ bị LazyInitializationException
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public OrderResponse getOrderById(@NonNull Long id) {
        OrderEntity order = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.toResponse(order);
    }
}