package com.example.persistant.controller;

import com.example.persistant.interfaces.ManagerDao;
import com.example.persistant.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    ManagerDao managerDao;

    @PostMapping("create")
    public boolean CreateManager(@RequestBody Manager manager){
        try{
            if(managerDao.createManager(manager)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            Throwable cause = e;
            return false;
        }
    }

    @PostMapping("get_manager_by_email")
    public Manager getManagerByEmail(@RequestBody Manager manager){
        try {
            return managerDao.getManagerByEmail(manager);
        }catch (NullPointerException e){
            Throwable cause = e;
            return null;
        }
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteManager(@PathVariable Long id){
        try {
            managerDao.deleteManager(id);
            return true;
        }catch (NullPointerException e){
            Throwable cause = e;
            return false;
        }
    }
}
