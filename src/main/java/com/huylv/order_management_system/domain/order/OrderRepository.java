package com.huylv.order_management_system.domain.order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
