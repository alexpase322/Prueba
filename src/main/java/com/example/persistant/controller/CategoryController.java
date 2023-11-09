package com.example.persistant.controller;


import com.example.persistant.interfaces.CategoryDao;
import com.example.persistant.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;

    @PostMapping("create")
    public String createCategory(@RequestBody Category category){
        try {
            boolean comprobacion = categoryDao.createCategory(category);
            if(comprobacion){
                return "No encontrado";
            }
        }catch(NullPointerException e) {
            return e.getMessage();
        }
        return "Encontrado";
    }

    @GetMapping("getcategory/{id}")
    public Category getCategoryById(@PathVariable Long id){
        try {
            return categoryDao.getCategoryById(id);
        }catch(NullPointerException e) {
            return null;
        }
    }

    @GetMapping("getcategories")
    public List<Category> getAllCategories(){
        return categoryDao.getAllCategories();
    }
}
