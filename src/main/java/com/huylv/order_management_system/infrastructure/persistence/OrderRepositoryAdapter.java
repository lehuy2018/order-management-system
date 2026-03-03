package com.huylv.order_management_system.infrastructure.persistence;

import com.huylv.order_management_system.domain.order.Order;
import com.huylv.order_management_system.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final SpringDataOrderRepository springDataRepository;

    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = toEntity(order);
        OrderJpaEntity saved = springDataRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return springDataRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Order> findAll() {
        return springDataRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataRepository.existsById(id);
    }

    private OrderJpaEntity toEntity(Order order) {
        OrderJpaEntity entity = new OrderJpaEntity();
        entity.setId(order.getId());
        entity.setName(order.getName());
        return entity;
    }

    private Order toDomain(OrderJpaEntity entity) {
        return new Order(entity.getId(), entity.getName());
    }
}
