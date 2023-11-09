package com.example.persistant.interfaces;


import com.example.persistant.models.Manager;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ManagerDaoImplement implements ManagerDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean createManager(Manager manager){
        try {
            String query = "FROM Manager WHERE idManager = :id_manager";
            List<Manager> managerList = entityManager.createQuery(query)
                    .setParameter("id_manager", manager.getIdManager())
                    .getResultList();
            if(managerList.isEmpty()){
                Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                String hash = argon2.hash(1, 1024, 1, manager.getPassword());
                manager.setPassword(hash);
                entityManager.merge(manager);
                return true;
            }
            return false;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }
    @Override
    public Manager getManagerByEmail(Manager manager) {
        try {
            String query = "FROM Manager WHERE email = :email";
            List<Manager> lista = entityManager.createQuery(query)
                    .setParameter("email", manager.getEmail())
                    .getResultList();
            if (lista.isEmpty()) {
                return null;
            }
            String passwordHashed = lista.get(0).getPassword();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if (argon2.verify(passwordHashed, manager.getPassword())) {
                return lista.get(0);
            }
            return null;

        }catch(NullPointerException e) {
            Throwable cause = e.getCause();
            return null;
        }
    }
    @Override
    public boolean deleteManager(Long id){
        try {
            Manager manager = entityManager.find(Manager.class, id);
            entityManager.remove(manager);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public Manager getManagerById(Long id){
        try{
            String query = "FROM Manager WHERE idManager=:id_manager";
            return (Manager) entityManager.createQuery(query)
                    .setParameter("id_manager", id)
                    .getSingleResult();
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return null;
        }
    }
}
