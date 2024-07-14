package com.ecommerce.springboot.util;

import com.ecommerce.springboot.model.Product;
import org.springframework.stereotype.Component;

@Component
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    // Node class representing each element in the binary tree
    private class Node {
        Product product;
        Node left;
        Node right;

        Node(Product product) {
            this.product = product;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a new node into the binary tree
    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private Node insertRec(Node root, Product product) {
        if (root == null) {
            root = new Node(product);
            return root;
        }
        if (product.getId() < root.product.getId()) {
            root.left = insertRec(root.left, product);
        } else if (product.getId() > root.product.getId()) {
            root.right = insertRec(root.right, product);
        }
        return root;
    }

    // Find a node in the binary tree
    public Product find(Long id) {
        Node node = findRec(root, id);
        if (node != null) {
            return node.product;
        }
        return null;
    }

    private Node findRec(Node root, Long id) {
        if (root == null || root.product.getId().equals(id)) {
            return root;
        }
        if (root.product.getId() > id) {
            return findRec(root.left, id);
        }
        return findRec(root.right, id);
    }

    // Delete a node from the binary tree
    public void delete(Long id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, Long id) {
        if (root == null) {
            return root;
        }
        if (id < root.product.getId()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.product.getId()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.product = minValue(root.right).product;
            root.right = deleteRec(root.right, root.product.getId());
        }
        return root;
    }

    private Node minValue(Node root) {
        Node minValueNode = root;
        while (root.left != null) {
            minValueNode = root.left;
            root = root.left;
        }
        return minValueNode;
    }

    // In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.product.getId() + ": " + root.product.getName());
            inorderRec(root.right);
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.product.getId() + ": " + root.product.getName());
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.product.getId() + ": " + root.product.getName());
        }
    }
}
