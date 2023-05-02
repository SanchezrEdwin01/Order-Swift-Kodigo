package com.example.orderswift.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_descrip")
    private String productDescrip;

    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    // Getters y setters
}
