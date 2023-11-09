package com.example.persistant.interfaces;

import com.example.persistant.models.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LocationDaoImplement implements LocationDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean CreateLocation(Location location){
        try {
            String query = "FROM Location WHERE siteLocation = :site_location";
            List<Location> locationList = entityManager.createQuery(query)
                    .setParameter("site_location", location.getSiteLocation())
                    .getResultList();
            if(locationList.isEmpty()){
                entityManager.merge(location);
                return true;
            }
            return false;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public Location getLocationById(Long id){
        try {
            String query = "FROM Location WHERE idLocation = :id_location";
            List<Location> locationById = entityManager.createQuery(query)
                    .setParameter("id_location", id)
                    .getResultList();
            if(!locationById.isEmpty()){
                return locationById.get(0);
            }
            return null;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return null;
        }
    }
}
