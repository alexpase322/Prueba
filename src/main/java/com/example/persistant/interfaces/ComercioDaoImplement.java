package com.example.persistant.interfaces;

import com.example.persistant.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ComercioDaoImplement implements ComercioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SubCategoryDao subCategoryDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    ManagerDao managerDao;

    @Autowired
    ComercioStatusDao comercioStatusDao;

    @Override
    public boolean CreateComercio(Comercio comercio){
        try {
            Subcategory subcategory = subCategoryDao.getSubcategoryById(comercio.getSubCategory().getSubCategoryId());
            Location location = locationDao.getLocationById(comercio.getLocation().getIdLocation());
            Manager manager = managerDao.getManagerById(comercio.getManager().getIdManager());
            ComercioStatus comercioStatus = comercioStatusDao.getStatusById(comercio.getComercioStatus().getComercioStatusId());

            comercio.setSubCategory(subcategory);
            comercio.setManager(manager);
            comercio.setLocation(location);
            comercio.setComercioStatus(comercioStatus);

            entityManager.merge(comercio);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public Comercio getComercioById(Long id){
        try {
            String query = "FROM Comercio WHERE idComercio=:id_comercio";
            return (Comercio) entityManager.createQuery(query)
                    .setParameter("id_comercio", id)
                    .getSingleResult();
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return null;
        }
    }
}
