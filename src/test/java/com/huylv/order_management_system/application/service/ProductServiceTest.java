package com.huylv.order_management_system.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.huylv.order_management_system.application.dto.ProductRequest;
import com.huylv.order_management_system.domain.model.Product;
import com.huylv.order_management_system.domain.repository.ProductRepository;
import com.huylv.order_management_system.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testCreateProduct() {
        ProductRequest request = new ProductRequest();
        request.setName("Test Product");
        request.setPrice(10.0);
        request.setQuantity(5);
        Product product = new Product();
        when(repository.save(any(Product.class))).thenReturn(product);
        Product result = productService.create(request);
        assertNotNull(result);
        verify(repository).save(any(Product.class));
    }

    @Test
    void testFindAll() {
        Product product = new Product();
        when(repository.findAll()).thenReturn(Arrays.asList(product));
        List<Product> result = productService.findAll();
        assertEquals(1, result.size());
    }

    @Test
    void testFindByIdFound() {
        Product product = new Product();
        when(repository.findById(1L)).thenReturn(Optional.of(product));
        Product result = productService.findById(1L);
        assertNotNull(result);
    }

    @Test
    void testFindByIdNotFound() {
        when(repository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> productService.findById(2L));
    }

    @Test
    void testDelete() {
        doNothing().when(repository).deleteById(1L);
        productService.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void testGetProducts() {
        Pageable pageable = PageRequest.of(0, 10);
        Product product = new Product();
        Page<Product> page = new PageImpl<>(Arrays.asList(product));
        when(repository.findAll(pageable)).thenReturn(page);
        assertNotNull(productService.getProducts(pageable));
    }
}
