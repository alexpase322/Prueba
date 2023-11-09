package com.example.persistant.interfaces;

import com.example.persistant.models.Mall;

public interface MallDao {
    boolean createMall(Mall mall);

    boolean deleteByName(String name);

    Mall getMallByName(Mall mall);

    Mall getMallById(Long id);
}
