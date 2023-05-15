package com.example.orderswift.service.category;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.Category;
import com.example.orderswift.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "New category has been added";
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer category_id) {
        return categoryRepository.findById(category_id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found for the id " + category_id));
    }

    @Override
    public Category updateCategory(Category newCategory, Integer category_id) {
        return categoryRepository.findById(category_id).map(category -> {
            category.setCategoryName(category.getCategoryName());
            return categoryRepository.save(category);
        }).orElseThrow(()-> new ResourceNotFoundException("Category not found for the id " + category_id));
    }

    @Override
    public String deleteCategory(Integer category_id) {
        return "The order with the ID num " + category_id + " has been deleted";
    }
}
