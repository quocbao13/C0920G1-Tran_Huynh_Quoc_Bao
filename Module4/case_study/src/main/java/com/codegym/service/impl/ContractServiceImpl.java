package com.codegym.service.impl;

import com.codegym.model.Contract;
import com.codegym.repository.ContractRepository;
import com.codegym.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

}
