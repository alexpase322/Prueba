package com.example.persistant.interfaces;

import com.example.persistant.models.Watchman;

import java.util.List;

public interface WatchmanDao {
    boolean createWatchman(Watchman watchman);

    boolean deleteWatchmanById(Long id);

    boolean editWatchman(Watchman watchman);


    Watchman getWatchmanById(Long id);

    List<Watchman> getAllWatchman();
}
