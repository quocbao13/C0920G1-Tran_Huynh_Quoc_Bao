package vn.codegym.cms.service.impl;

import org.springframework.stereotype.Service;
import vn.codegym.cms.model.Customer;
import vn.codegym.cms.repository.CustomerRepository;
import vn.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CustomerServiecImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}