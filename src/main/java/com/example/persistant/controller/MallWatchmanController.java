package com.example.persistant.controller;


import com.example.persistant.interfaces.MallwatchmanDao;
import com.example.persistant.models.MallWatchman;
import com.example.persistant.models.Watchman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asignar")
public class MallWatchmanController {
    @Autowired
    MallwatchmanDao mallwatchmanDao;

    @PostMapping("{watchmanId}/{mallId}")
    public boolean asignarVigilante(@PathVariable Long watchmanId,@PathVariable Long mallId){
        try {
            if(mallwatchmanDao.asignarVigilante(watchmanId, mallId)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @GetMapping("getall/{id}")
    public List<Watchman> getAllMallWatchman(@PathVariable Long id){
        try {
            return mallwatchmanDao.getAllByIdMall(id);
        }catch (NullPointerException e){
            return null;
        }
    }


}
