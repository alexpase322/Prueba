package com.example.persistant.interfaces;

import com.example.persistant.models.Manager;

public interface ManagerDao {
    boolean createManager(Manager manager);

    Manager getManagerByEmail(Manager manager);

    boolean deleteManager(Long id);

    Manager getManagerById(Long id);
}
