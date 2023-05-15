package com.example.orderswift.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Category name must not be null or blank")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategories;
}