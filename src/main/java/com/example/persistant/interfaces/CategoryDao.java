package com.example.persistant.interfaces;

import com.example.persistant.models.Category;

import java.util.List;


public interface CategoryDao {

    boolean createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
