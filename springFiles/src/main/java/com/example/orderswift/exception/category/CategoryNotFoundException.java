package com.example.orderswift.exception.category;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(Integer category_id) {super("Could not found the category with the id " + category_id);}
}
