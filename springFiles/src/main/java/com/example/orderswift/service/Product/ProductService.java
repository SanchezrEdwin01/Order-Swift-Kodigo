package com.example.orderswift.service.Product;

import com.example.orderswift.model.Order;
import com.example.orderswift.model.Product;

import java.util.List;

public interface ProductService {
    String addProduct(Product product);

    public List<Product> getProducts();

    Product getProductById(Integer productId);

    Product updateProduct(Product newproduct, Integer productId);

    String deleteProduct(Integer productId);
}
