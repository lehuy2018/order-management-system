package com.huylv.order_management_system.application.dto;

import java.util.List;

public record ProductPageResponse(
    List<ProductResponse> content,
    int pageNumber,
    int pageSize,
    long totalElements,
    int totalPages) {
}