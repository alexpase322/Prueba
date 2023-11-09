package com.example.persistant.controller;

import com.example.persistant.interfaces.AdminDao;
import com.example.persistant.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminDao adminDao;

    @PostMapping("create")
    public boolean CreateAdmin(@RequestBody Admin admin){
        try {
            if(adminDao.createAdmin(admin)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            System.out.println(e);
            return false;
        }
    }
}
