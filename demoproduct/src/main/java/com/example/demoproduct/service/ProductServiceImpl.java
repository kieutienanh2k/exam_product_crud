package com.example.demoproduct.service;

import com.example.demoproduct.entity.ProductEntity;
import com.example.demoproduct.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;


    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = productRepo.save(product);
        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(Integer id, Integer quantity) {
        ProductEntity productEntity = productRepo.getById(id);
        int result = 0;
        result = (productEntity.getQuantity()) - quantity;
        if (productEntity != null){
            productEntity.setQuantity(result);
            return productRepo.save(productEntity);
        }
        return null;
    }
}
