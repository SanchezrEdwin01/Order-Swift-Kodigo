package com.example.orderswift.controller;

import com.example.orderswift.model.Product;
import com.example.orderswift.security.JwtAuthorizationRequired;
import com.example.orderswift.service.product.ProductServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductServiceImp productServiceImpl;
    /*READ*/
    @Operation(summary = "It gets the list of all products have been added")
    @GetMapping("/getproducts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @JwtAuthorizationRequired("ADMIN")
    public List<Product> AllProduct(){
        return productServiceImpl.getProducts();
    }

    /*READ SPECIFY PRODUCT*/
    @Operation(summary = "It gets a product by id order")
    @GetMapping("/getById/{product_id}")
    public Product getProductById(@PathVariable Integer productId){return productServiceImpl.getProductById(productId);}

    /*ADD NEW PRODUCT*/
    @Operation(summary = "It creates a new product")
    @PostMapping("/add")

    public String addProduct(@RequestBody Product product) {return productServiceImpl.addProduct(product);}

    @Operation(summary = "It updates a new product by its id")
    /*UPDATE PRODUCT*/
    @PutMapping("/update/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer productId){
        return productServiceImpl.updateProduct(product,productId);
    }

    /*DELETE A PRODUCT*/

    @Operation(summary = "It deletes a new product by its id")
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {return productServiceImpl.deleteProduct(productId);}
    }


