package com.codegym.service;


import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Long id);

    void update(Contract contract);

    Contract findById(Long id);

}
