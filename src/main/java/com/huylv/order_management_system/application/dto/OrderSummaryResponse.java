package com.huylv.order_management_system.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderSummaryResponse {
    private int totalOrders;
    private long totalRevenue;
}