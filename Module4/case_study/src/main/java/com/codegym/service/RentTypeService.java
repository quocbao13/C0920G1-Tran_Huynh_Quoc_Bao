package com.codegym.service;

import com.codegym.model.RentType;

import java.util.List;

public interface RentTypeService  {
    List<RentType> findAll();

    void save(RentType RentType);

    void update(RentType RentType);

    void delete(Long id);

    RentType findById(Long id);
}
