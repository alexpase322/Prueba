package com.example.persistant.controller;

import com.example.persistant.interfaces.ComercioDao;
import com.example.persistant.models.Comercio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comercio")
public class ComercioController {
    @Autowired
    ComercioDao comercioDao;

    @PostMapping("create")
    public boolean CreateComercio(@RequestBody Comercio comercio){
        try {
            if(comercioDao.CreateComercio(comercio)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }

    @GetMapping("getbyid/{id}")
    public Comercio getComercioById(@PathVariable Long id){
        try {
            Comercio comercio = comercioDao.getComercioById(id);
            if(comercio!=null){
                return comercio;
            }
            return null;
        }catch (NullPointerException e){
            Throwable cause = e;
            return null;
        }
    }
}
