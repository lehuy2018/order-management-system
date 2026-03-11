package com.huylv.order_management_system.application.mapper;

import com.huylv.order_management_system.application.dto.OrderRequest;
import com.huylv.order_management_system.application.dto.OrderResponse;
import com.huylv.order_management_system.domain.model.OrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(OrderRequest request) {

        OrderEntity order = new OrderEntity();
        order.setCustomerName(request.getCustomerName());
        order.setTotalPrice(request.getTotalPrice());

        return order;
    }

    public static OrderResponse toResponse(OrderEntity entity) {

        return new OrderResponse(
                entity.getId(),
                entity.getCustomerName(),
                entity.getTotalPrice(),
                entity.getStatus()
        );
    }
}