package com.example.orderswift.controller;

import com.example.orderswift.model.Category;
import com.example.orderswift.service.category.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Category", description = "This controller makes a CRUD of all the category products")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*Create*/
    @Operation(summary = "It creates a new category")
    @PostMapping("/add")
    public String add(@RequestBody Category category) {return categoryService.saveCategory(category);}

    /*Read*/
    @Operation(summary = "It gets a category by its id")
    @GetMapping("/getById/{category_id}")
    public Category getCategoryById(@PathVariable Integer category_id){return categoryService.getCategoryById(category_id);}

    @Operation(summary = "It gets all the category have been made")
    @GetMapping("/getCategory")
    public List<Category> getCategories(){return categoryService.getCategories();}

    /*Update*/
    @Operation(summary = "It updates a category by its id")
    @PutMapping("/update/{category_id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Integer category_id){
        return categoryService.updateCategory(category, category_id);
    }

    /*Delete*/
    @Operation(summary = "It deletes a category by its id")
    @DeleteMapping("/delete/{category_id}")
    public String deleteCategory(@PathVariable Integer category_id) {return categoryService.deleteCategory(category_id);}
}
