package com.example.orderswift.controller;
import com.example.orderswift.model.*;
import com.example.orderswift.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    /*READ*/
    @GetMapping("/getproducts")
    public List<Product> AllProduct(){
        return productService.getProducts();
    }
    @GetMapping("/getById/{product_id}")
    public Optional<Product> getProductById(@PathVariable Integer productId){return productService.getProductid(productId);}



    @PostMapping("/update")
    public void  createProduct(@RequestBody Product product) {productService.saveOrUpdate(product);}

    /*DELETE*/
    @DeleteMapping("/Delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) {
        Optional<Product> product = productService.getProductid(productId);

        if (product.isPresent()) {
            productService.delete(productId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
