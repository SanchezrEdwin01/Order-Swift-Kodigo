package com.example.orderswift.controller;

import com.example.orderswift.model.Product;
import com.example.orderswift.security.JwtAuthorizationRequired;
import com.example.orderswift.service.Product.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductServiceImp productServiceImp;
    /*READ*/
    @GetMapping("/getproducts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @JwtAuthorizationRequired("")
    public List<Product> AllProduct(){
        return productServiceImp.getProducts();
    }

    /*READ SPECIFY PRODUCT*/
    @GetMapping("/getById/{product_id}")
    public Product getProductById(@PathVariable Integer productId){return productServiceImp.getProductById(productId);}

    /*ADD NEW PRODUCT*/
    @PostMapping("/add")

    public String addProduct(@RequestBody Product product) {return productServiceImp.addProduct(product);}

    /*UPDATE PRODUCT*/
    @PutMapping("/update/{productId}")
    public Product updateProdcut(@RequestBody Product product, @PathVariable Integer productId){
        return productServiceImp.updateProduct(product,productId);
    }

    /*DELETE A PRODUCT*/

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {return productServiceImp.deleteProduct(productId);}
    }


