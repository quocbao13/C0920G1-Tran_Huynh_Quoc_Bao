package com.example.service;


import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    Optional<User> findOne(Long id);

    void save(User user);

    void delete(Long id);
}
