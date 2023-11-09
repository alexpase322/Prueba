package com.example.persistant.controller;

import com.example.persistant.interfaces.SubCategoryDao;
import com.example.persistant.models.Subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("subcategories")
public class SubCategoryController {

    @Autowired
    SubCategoryDao subCategoryDao;

    @PostMapping(value = "create", consumes = {"*/*"})
    public boolean CreateSubCategory(@RequestBody Subcategory subCategory){
        try {

            subCategoryDao.createSubCategory(subCategory);
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }


    @GetMapping("allsubcategories")
    public List<Subcategory> getAllSubCategories(){
        try {
            List<Subcategory> lista = subCategoryDao.getAllSubcategories();
            if(lista!=null){
                return lista;
            }
            return new ArrayList<>();
        }catch (NullPointerException e){
            return new ArrayList<>();
        }
    }
}
