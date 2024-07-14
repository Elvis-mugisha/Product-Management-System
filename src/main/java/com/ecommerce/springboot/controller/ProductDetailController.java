package com.ecommerce.springboot.controller;

import com.ecommerce.springboot.model.ProductDetail;
import com.ecommerce.springboot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-details")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    // Get all product details
    @GetMapping
    public List<ProductDetail> getAllProductDetails() {
        return productDetailService.getAllProductDetails();
    }

    // Get product detail by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetail> getProductDetailById(@PathVariable Long id) {
        Optional<ProductDetail> productDetail = productDetailService.getProductDetailById(id);
        if (productDetail.isPresent()) {
            return ResponseEntity.ok(productDetail.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new product detail
    @PostMapping
    public ProductDetail createProductDetail(@RequestBody ProductDetail productDetail) {
        return productDetailService.createProductDetail(productDetail);
    }

    // Update an existing product detail
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetail> updateProductDetail(@PathVariable Long id, @RequestBody ProductDetail productDetailDetails) {
        Optional<ProductDetail> updatedProductDetail = productDetailService.updateProductDetail(id, productDetailDetails);
        if (updatedProductDetail.isPresent()) {
            return ResponseEntity.ok(updatedProductDetail.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a product detail
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductDetail(@PathVariable Long id) {
        if (productDetailService.deleteProductDetail(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
