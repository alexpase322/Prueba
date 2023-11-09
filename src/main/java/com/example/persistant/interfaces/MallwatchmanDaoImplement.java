package com.example.persistant.interfaces;


import com.example.persistant.models.Comercio;
import com.example.persistant.models.Mall;
import com.example.persistant.models.MallWatchman;
import com.example.persistant.models.Watchman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MallwatchmanDaoImplement implements MallwatchmanDao {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MallDao mallDao;

    @Autowired
    WatchmanDao watchmanDao;

    @Autowired
    ComercioDao comercioDao;

    @Override
    public boolean asignarVigilante(Long watchmanId, Long mallId){
        try {
            Mall mall_find = mallDao.getMallById(mallId);
            Watchman watchman_find = watchmanDao.getWatchmanById(watchmanId);
            MallWatchman mallWatchman = new MallWatchman();
            mallWatchman.setMall(mall_find);
            mallWatchman.setWatchman(watchman_find);
            entityManager.merge(mallWatchman);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e.getCause();
            return false;
        }
    }

    @Override
    public List<Watchman> getAllByIdMall(Long id){
        try {
            Mall mall = entityManager.find(Mall.class, id);
            String query = "FROM MallWatchman WHERE mall.idMall=:mall_id";
            List <MallWatchman> lista = entityManager.createQuery(query)
                    .setParameter("mall_id", id)
                    .getResultList();
            List<Watchman> watchmanList = new ArrayList<>();
            if(lista.isEmpty()){
                return null;
            }
            for(int i=0; i<lista.size(); i++){
                Watchman watchman = watchmanDao.getWatchmanById(lista.get(i).getWatchman().getWatchmanId());
                watchmanList.add(watchman);
            }
            return watchmanList;
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }


}
