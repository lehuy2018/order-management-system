package com.huylv.order_management_system.application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.huylv.order_management_system.application.dto.ProductRequest;
import com.huylv.order_management_system.domain.model.Product;
import com.huylv.order_management_system.domain.repository.ProductRepository;
import com.huylv.order_management_system.exception.ResourceNotFoundException;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCreatedAt(LocalDateTime.now());

        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        if (id != null) {
            return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        } else {
            throw new RuntimeException("Product id is null");
        }
    }

    public void delete(Long id) {
        if (id != null) {
            repository.deleteById(id);
        }
    }

    public Page<Product> getProducts(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }
}