package com.example.persistant.interfaces;

import com.example.persistant.models.Subcategory;

import java.util.List;

public interface SubCategoryDao {
    boolean createSubCategory(Subcategory subCategory);

    List<Subcategory> getAllSubcategories();

    Subcategory getSubcategoryById(Long id);
}
