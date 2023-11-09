package com.example.persistant.interfaces;

import com.example.persistant.models.Mall;
import com.example.persistant.models.MallWatchman;
import com.example.persistant.models.Watchman;

import java.util.List;

public interface MallwatchmanDao {
    boolean asignarVigilante(Long watchmanId, Long mallId);

    List<Watchman> getAllByIdMall(Long id);

}
