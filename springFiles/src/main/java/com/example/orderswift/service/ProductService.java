package com.example.orderswift.service;
import com.example.orderswift.model.Order;
import com.example.orderswift.model.Product;
import com.example.orderswift.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductid(Integer productId) {
        return productRepository.findById(productId);
    }

    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }

    public void delete(Integer productId) {
        productRepository.deleteById(productId);
    }
}
