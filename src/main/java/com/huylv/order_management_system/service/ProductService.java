package com.huylv.order_management_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.huylv.order_management_system.dto.ProductRequest;
import com.huylv.order_management_system.entity.Product;
import com.huylv.order_management_system.exception.ResourceNotFoundException;
import com.huylv.order_management_system.repository.ProductRepository;

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
}