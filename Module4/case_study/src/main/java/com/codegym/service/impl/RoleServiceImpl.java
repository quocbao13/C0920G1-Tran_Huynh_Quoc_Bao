package com.codegym.service.impl;

import com.codegym.model.Role;
import com.codegym.repository.RoleRepository;
import com.codegym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
