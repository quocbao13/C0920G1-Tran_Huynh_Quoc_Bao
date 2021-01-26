package com.codegym.service.impl;

import com.codegym.model.ServiceType;
import com.codegym.repository.ServiceTypeRepository;
import com.codegym.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void update(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void delete(Long id) {
        serviceTypeRepository.deleteById(id);
    }

    @Override
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }
}
