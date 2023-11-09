package com.example.persistant.controller;

import com.example.persistant.interfaces.WatchmanDao;
import com.example.persistant.models.Watchman;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vigilantes")
public class WatchmanController {
    @Autowired
    WatchmanDao watchmanDao;

    @PostMapping("create")
    public boolean createWatchman(@RequestBody Watchman watchman){
        try {
            watchmanDao.createWatchman(watchman);
            return true;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteWatchman(@PathVariable Long id){
        try {
            if(watchmanDao.deleteWatchmanById(id)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @PutMapping("editar")
    public boolean editWatchman(@RequestBody Watchman watchman){
        try {
            watchmanDao.editWatchman(watchman);
            return true;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @GetMapping("getvigilante/{id}")
    public Watchman getWatchmanById(@PathVariable Long id){
        try {
            Watchman watchman = watchmanDao.getWatchmanById(id);
            if(watchman!=null){
                return watchman;
            }
            return null;
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("get_all_vigilantes")
    public List<Watchman> getAllWatchman(){
        try {
            return watchmanDao.getAllWatchman();
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }
}
