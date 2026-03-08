package com.huylv.order_management_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huylv.order_management_system.domain.model.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}