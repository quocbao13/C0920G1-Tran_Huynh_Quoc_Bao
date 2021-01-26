package com.codegym.service.impl;

import com.codegym.model.RentType;
import com.codegym.repository.RentTypeRepository;
import com.codegym.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void update(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(Long id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}
