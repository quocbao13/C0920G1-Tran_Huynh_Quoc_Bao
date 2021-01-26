package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);
    void delete(Long id);
    Customer findById(Long id);

    Page<Customer> findAllByCustomer_nameContaining(Pageable pageable, String nameSearch);

}
