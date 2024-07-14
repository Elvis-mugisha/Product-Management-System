package com.ecommerce.springboot.service;
import com.ecommerce.springboot.model.*;
import com.ecommerce.springboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.springboot.util.BinaryTree;

import java.util.*;




@Service

public class ProductService {


    private ProductRepository productRepository;


    private BinaryTree binaryTree;

    @Autowired
    public ProductService(BinaryTree binaryTree, ProductRepository productRepository) {
        this.binaryTree = binaryTree;
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        binaryTree.insert(product);
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return binaryTree.find(id);
    }

    public void deleteProduct(Long id) {
        binaryTree.delete(id);
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void printInOrder() {
        binaryTree.inorder();
    }

    public void printPreOrder() {
        binaryTree.preorder();
    }

    public void printPostOrder() {
        binaryTree.postorder();
    }
}
