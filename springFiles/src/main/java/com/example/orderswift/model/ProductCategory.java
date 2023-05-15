package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "ProductCategory")
@Table(name = "products_categories")
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "product_category_id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
