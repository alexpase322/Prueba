package com.example.persistant.interfaces;


import com.example.persistant.models.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImplement implements CategoryDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean createCategory(Category category){
        try {
            String query = "FROM Category WHERE name= :name";
            List<Category> categories = entityManager.createQuery(query)
                    .setParameter("name", category.getName())
                    .getResultList();
            if (!categories.isEmpty()){
                return false;
            }else{
                entityManager.merge(category);
                return true;
            }
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public List<Category> getAllCategories(){
        try{
            String query = "FROM Category";
            List<Category> categories = entityManager.createQuery(query).getResultList();
            if(categories.isEmpty()){
                return new ArrayList<>();
            }else{
                return categories;
            }
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return new ArrayList<>();
        }
    }
    @Override
    public Category getCategoryById(Long id){
        try{
            String query = "FROM Category WHERE categoryId = :category_id";
            List<Category> lista = entityManager.createQuery(query)
                    .setParameter("category_id", id)
                    .getResultList();
            return lista.get(0);
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return null;
        }

    }
}
