package com.example.orderswift.service.category;

import com.example.orderswift.model.Category;
import java.util.List;

public interface CategoryService {

    String saveCategory(Category category);

    public List<Category> getCategories();

    Category getCategoryById(Integer category_id);

    Category updateCategory(Category category, Integer category_id);

    String deleteCategory(Integer category_id);

}
