package com.example.persistant.interfaces;

import com.example.persistant.models.Comercio;

public interface ComercioDao {
    boolean CreateComercio(Comercio comercio);

    Comercio getComercioById(Long id);
}
