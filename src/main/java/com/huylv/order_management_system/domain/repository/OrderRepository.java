package com.huylv.order_management_system.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huylv.order_management_system.domain.enums.OrderStatus;
import com.huylv.order_management_system.domain.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Page<OrderEntity> findByStatus(OrderStatus status, Pageable pageable);

    @Query("""
        SELECT o FROM OrderEntity o
        JOIN FETCH o.items
        """)
    List<OrderEntity> findAllWithItems();
}