package com.example.persistant.interfaces;

import com.example.persistant.models.Watchman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class WatchmanDaoImplement implements WatchmanDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean createWatchman(Watchman watchman){
        try {
            entityManager.merge(watchman);
            return true;
        }catch (NullPointerException e){
            System.out.println(e.getCause());
            return false;
        }
    }

    @Override
    public boolean deleteWatchmanById(Long id){
        try {
            String query = "FROM Watchman WHERE watchmanId=:watchman_id";
            List<Watchman> lista = entityManager.createQuery(query)
                    .setParameter("watchman_id", id)
                    .getResultList();
            if(!lista.isEmpty()){
                entityManager.remove(lista.get(0));
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e.getCause());
            return false;
        }
    }

    @Override
    public boolean editWatchman(Watchman watchman){
        try {
            String query = "FROM Watchman WHERE watchmanId=:watchman_id";
            List<Watchman> lista = entityManager.createQuery(query)
                    .setParameter("watchman_id", watchman.getWatchmanId())
                    .getResultList();
            if(lista.isEmpty()){
                return false;
            }
            lista.get(0).setLastName(watchman.getLastName());
            lista.get(0).setName(watchman.getName());
            entityManager.merge(lista.get(0));
            return true;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Watchman getWatchmanById(Long id){
        try {
            Watchman watchman = entityManager.find(Watchman.class, id);
            return watchman;
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Watchman> getAllWatchman(){
        try {
            String query = "FROM Watchman";
            return entityManager.createQuery(query).getResultList();
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }
}
