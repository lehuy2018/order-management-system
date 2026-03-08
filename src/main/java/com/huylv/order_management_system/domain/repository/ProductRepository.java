package com.huylv.order_management_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huylv.order_management_system.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}