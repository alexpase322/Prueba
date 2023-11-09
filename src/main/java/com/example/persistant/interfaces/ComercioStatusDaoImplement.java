package com.example.persistant.interfaces;

import com.example.persistant.models.ComercioStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ComercioStatusDaoImplement implements ComercioStatusDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean CreateStatus(ComercioStatus comercioStatus){
        try {
            entityManager.merge(comercioStatus);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public List<ComercioStatus> getAllStatus(){
        try {
            String query = "FROM ComercioStatus";
            List<ComercioStatus> lista = entityManager.createQuery(query).getResultList();
            if(lista.isEmpty()){
                return null;
            }
            return lista;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return null;
        }
    }

    @Override
    public ComercioStatus getStatusById(Long id){
        try {
            String query = "FROM ComercioStatus WHERE comercioStatusId = :comercio_status_id";
            List<ComercioStatus> lista = entityManager.createQuery(query)
                    .setParameter("comercio_status_id", id)
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
