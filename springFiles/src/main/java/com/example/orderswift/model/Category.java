package com.example.orderswift.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "Category")
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategories;
}