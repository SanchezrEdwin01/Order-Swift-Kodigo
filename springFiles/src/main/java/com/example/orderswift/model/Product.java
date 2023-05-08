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
    private Long productId;

    @Column(
            name = "product_name",
            nullable = false
    )
    private String productName;

    @Column(name = "product_descrip")
    private String productDescrip;

    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}