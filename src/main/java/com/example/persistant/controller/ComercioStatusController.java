package com.example.persistant.controller;


import com.example.persistant.interfaces.ComercioStatusDao;
import com.example.persistant.interfaces.ComercioStatusDaoImplement;
import com.example.persistant.models.ComercioStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("status")
public class ComercioStatusController {
    @Autowired
    ComercioStatusDao comercioStatusDao;

    @PostMapping("create")
    public boolean CreateStatus(@RequestBody ComercioStatus comercioStatus){
        try {
            if(comercioStatusDao.CreateStatus(comercioStatus)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            Throwable cause = e;
            return false;
        }
    }

    @GetMapping("getall")
    public List<ComercioStatus> getAllStatus(){
        try {
            List<ComercioStatus> lista = comercioStatusDao.getAllStatus();
            if(lista!=null){
                return lista;
            }
            return null;
        }catch (NullPointerException e){
            Throwable cause = e;
            return null;
        }
    }

    @GetMapping("getById/{id}")
    public ComercioStatus getStatusById(@PathVariable Long id){
        try {
            ComercioStatus comercioStatus = comercioStatusDao.getStatusById(id);
            if(comercioStatus!=null){
                return comercioStatus;
            }
            return null;
        }catch (NullPointerException e){
            Throwable cause = e;
            return null;
        }
    }
}
