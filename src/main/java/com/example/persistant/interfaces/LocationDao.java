package com.example.persistant.interfaces;

import com.example.persistant.models.Location;

public interface LocationDao {
    boolean CreateLocation(Location location);

    Location getLocationById(Long id);
}
