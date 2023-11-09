package com.example.persistant.interfaces;


import com.example.persistant.models.Admin;
import com.example.persistant.models.Category;
import com.example.persistant.models.Mall;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AdminDaoImplement implements AdminDao{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MallDao mallDao;

    @Override
    public boolean createAdmin(Admin admin){
        try {
            Mall mall = mallDao.getMallById(admin.getMall().getIdMall());
            admin.setMall(mall);
            entityManager.merge(admin);
            return true;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }
}
