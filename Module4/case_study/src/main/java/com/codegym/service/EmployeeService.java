package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee findById(Long id);

    Page<Employee> findAllByEmployeeNameContaining(String nameSearch,Pageable pageable);
}
