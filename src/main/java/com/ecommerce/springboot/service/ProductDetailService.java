package com.ecommerce.springboot.service;

import com.ecommerce.springboot.model.ProductDetail;
import com.ecommerce.springboot.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    public List<ProductDetail> getAllProductDetails() {
        return productDetailRepository.findAll();
    }

    public Optional<ProductDetail> getProductDetailById(Long id) {
        return productDetailRepository.findById(id);
    }

    public ProductDetail createProductDetail(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    public Optional<ProductDetail> updateProductDetail(Long id, ProductDetail productDetailDetails) {
        return productDetailRepository.findById(id).map(productDetail -> {
            productDetail.setDescription(productDetailDetails.getDescription());
            productDetail.setProduct(productDetailDetails.getProduct());
            return productDetailRepository.save(productDetail);
        });
    }

    public boolean deleteProductDetail(Long id) {
        return productDetailRepository.findById(id).map(productDetail -> {
            productDetailRepository.delete(productDetail);
            return true;
        }).orElse(false);
    }
}
