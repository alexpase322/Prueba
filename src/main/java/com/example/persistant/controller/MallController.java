package com.example.persistant.controller;

import com.example.persistant.interfaces.MallDao;
import com.example.persistant.models.Mall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mall")
public class MallController {
    @Autowired
    MallDao mallDao;

    @PostMapping("createmall")
    public boolean CreateMall(@RequestBody Mall mall){
        try {
            if(mallDao.createMall(mall)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @DeleteMapping("delete")
    public boolean DeleteMall(@RequestBody String name){
        try {
            mallDao.deleteByName(name);
            return true;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @GetMapping("get_by_name")
    public Mall GetMallByName(@RequestBody Mall mall){
        try {
            return mallDao.getMallByName(mall);
        }catch (NullPointerException e){
            System.out.println(e);
            return null;
        }
    }
}
