package com.example.orderswift.service.product;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.Product;
import com.example.orderswift.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
    }

    @Override
    public String addProduct(Product product) {
        productRepository.save(product);
        return "New product has been added";
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found for the id " + productId));
    }

    @Override
    public Product updateProduct(Product newproduct, Integer productId) {
        return productRepository.findById(productId).map(product -> {
            product.setProductName (newproduct.getProductName());
            product.setProductDescrip (newproduct.getProductDescrip());
            product.setPrice(newproduct.getPrice());

            return productRepository.save(product);
        }).orElseThrow(()->new ResourceNotFoundException("Product not found for the id " + productId));
    }

    @Override
    public String deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return "The product with ID num " + productId + " has been deleted";
    }
}
