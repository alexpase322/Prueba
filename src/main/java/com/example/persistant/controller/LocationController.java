package com.example.persistant.controller;

import com.example.persistant.interfaces.LocationDao;
import com.example.persistant.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("location")
public class LocationController {
    @Autowired
    LocationDao locationDao;

    @PostMapping("create_location")
    public boolean CreateLocation(@RequestBody Location location){
        try {
            if(locationDao.CreateLocation(location)){
                return true;
            }
            return false;
        }catch (NullPointerException e){
            Throwable cause = e;
            return false;
        }
    }

    @GetMapping("get_location/{id}")
    public Location GetLocationById(@PathVariable Long id){
        try {
            return locationDao.getLocationById(id);
        }catch (NullPointerException e){
            Throwable cause = e;
            return null;
        }
    }
}
