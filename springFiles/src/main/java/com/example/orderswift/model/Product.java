package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "Product")
@Table(name = "products")
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "product_id",
            updatable = false
    )
    private Integer productId;

    @Column(
            name = "product_name",
            nullable = false
    )
    private String productName;

    @Column(name = "product_descrip")
    private String productDescrip;

    private BigDecimal price;

    public Product(int i, String s) {
    }

    public Product() {

    }

    public void setName(String productName) {
    }

    public void setDescription(String productDescription) {
    }

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories;
}