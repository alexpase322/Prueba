package com.example.persistant.interfaces;


import com.example.persistant.models.Comercio;
import com.example.persistant.models.Mall;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MallDaoImplement implements MallDao{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ComercioDao comercioDao;

    @Override
    public boolean createMall(Mall mall){
        try {
            String query = "FROM Mall WHERE name = :name";
            List<Mall> list = entityManager.createQuery(query)
                    .setParameter("name", mall.getName())
                    .getResultList();
            if(list.isEmpty()){
                Comercio comercio = comercioDao.getComercioById(mall.getComercio().getIdComercio());
                mall.setComercio(comercio);
                entityManager.merge(mall);
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteByName(String name){
        try {
            String query = "FROM Mall WHERE name =:name";
            List<Mall> list = entityManager.createQuery(query)
                    .setParameter("name", name)
                    .getResultList();
            if(list.isEmpty()){
                return false;
            }
            entityManager.remove(list.get(0));
            return true;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Mall getMallByName(Mall mall){
        try {
            String query = "FROM Mall WHERE name =:name";
            List<Mall> list = entityManager.createQuery(query)
                    .setParameter("name", mall.getName())
                    .getResultList();
            if(list.isEmpty()){
                return null;
            }
            return list.get(0);
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Mall getMallById(Long id){
        try {
            String query = "FROM Mall WHERE idMall =:id_mall";
            List<Mall> list = entityManager.createQuery(query)
                    .setParameter("id_mall", id)
                    .getResultList();
            if(list.isEmpty()){
                return null;
            }
            return list.get(0);
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }
}
