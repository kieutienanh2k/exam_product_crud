package com.example.demoproduct.controller;

import com.example.demoproduct.entity.ProductEntity;
import com.example.demoproduct.model.BaseResponse;
import com.example.demoproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity home(Model model) {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping
    public BaseResponse createProduct(@RequestBody ProductEntity product) {
        BaseResponse res = new BaseResponse();
        res.data = productService.createProduct(product);
        return res;
    }

    @PutMapping
    public ResponseEntity update(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
                                 @RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity ) {

        return ResponseEntity.ok(productService.updateProduct(id, quantity));

    }
}
