package com.codegym.service;

import com.codegym.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);

    void update(CustomerType customerType);

    void delete(Long id);

    CustomerType findById(Long id);
}
