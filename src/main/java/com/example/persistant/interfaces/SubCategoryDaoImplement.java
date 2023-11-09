package com.example.persistant.interfaces;

import com.example.persistant.models.Category;
import com.example.persistant.models.Subcategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SubCategoryDaoImplement implements SubCategoryDao{
    @Autowired
    CategoryDao categoryDao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean createSubCategory(Subcategory subCategory){
        try{
            Category category = categoryDao.getCategoryById(subCategory.getCategory().getCategoryId());
            subCategory.setCategory(category);
            entityManager.merge(subCategory);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public List<Subcategory> getAllSubcategories(){
        try {
            String query = "FROM Subcategory";
            List<Subcategory> list =  entityManager.createQuery(query).getResultList();
            if(list.isEmpty()){
                return new ArrayList<>();
            }
            return list;
        }catch (NullPointerException e){
            return new ArrayList<>();
        }
    }

    @Override
    public Subcategory getSubcategoryById(Long id){
        try {
            String query = "FROM Subcategory WHERE subCategoryId = :sub_category_id";
            List<Subcategory> lista = entityManager.createQuery(query)
                    .setParameter("sub_category_id", id)
                    .getResultList();
            if(lista.isEmpty()){
                return null;
            }
            return lista.get(0);
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return null;
        }
    }
}
