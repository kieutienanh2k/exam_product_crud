package com.example.demoproduct.service;

import com.example.demoproduct.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduct();
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(Integer id, Integer quantity);
}
