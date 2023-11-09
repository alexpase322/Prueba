package com.example.persistant.interfaces;

import com.example.persistant.models.ComercioStatus;

import java.util.List;

public interface ComercioStatusDao {
    boolean CreateStatus(ComercioStatus comercioStatus);

    List<ComercioStatus> getAllStatus();

    ComercioStatus getStatusById(Long id);
}
