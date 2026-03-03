package com.huylv.order_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huylv.order_management_system.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}