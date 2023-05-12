package com.example.orderswift.controller;

import com.example.orderswift.model.*;
import com.example.orderswift.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    /*READ*/
    @GetMapping("/getproducts")
    public List<Product> AllProduct(){
        return productServiceImpl.getProducts();
    }

    /*READ SPECIFY PRODUCT*/
    @GetMapping("/getById/{product_id}")
    public Product getProductById(@PathVariable Integer productId){return productServiceImpl.getProductById(productId);}

    /*ADD NEW PRODUCT*/
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {return productServiceImpl.addProduct(product);}

    /*UPDATE PRODUCT*/
    @PutMapping("/update/{productId}")
    public Product updateProdcut(@RequestBody Product product, @PathVariable Integer productId){
        return productServiceImpl.updateProduct(product,productId);
    }

    /*DELETE A PRODUCT*/

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {return productServiceImpl.deleteProduct(productId);}
    }


