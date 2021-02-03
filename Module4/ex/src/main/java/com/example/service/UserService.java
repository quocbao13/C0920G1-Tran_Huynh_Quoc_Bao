package com.example.service;


import com.example.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUserName(String username);
}
