package com.huylv.order_management_system.application.order;

import com.huylv.order_management_system.application.order.dto.CreateOrderRequest;
import com.huylv.order_management_system.application.order.dto.OrderResponse;
import com.huylv.order_management_system.application.order.dto.UpdateOrderRequest;
import com.huylv.order_management_system.domain.order.Order;
import com.huylv.order_management_system.domain.order.OrderRepository;
import com.huylv.order_management_system.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {

    private final OrderRepository orderRepository;

    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream()
                .map(o -> new OrderResponse(o.getId(), o.getName()))
                .toList();
    }

    public OrderResponse findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return new OrderResponse(order.getId(), order.getName());
    }

    public OrderResponse create(CreateOrderRequest request) {
        Order saved = orderRepository.save(new Order(request.getName()));
        return new OrderResponse(saved.getId(), saved.getName());
    }

    public OrderResponse update(Long id, UpdateOrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setName(request.getName());
        Order saved = orderRepository.save(order);
        return new OrderResponse(saved.getId(), saved.getName());
    }

    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }
}
