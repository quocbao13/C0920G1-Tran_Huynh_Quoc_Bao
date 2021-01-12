package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping(value = "/")
    public ModelAndView showList(Pageable pageable){
        return new ModelAndView("users/index", "userList", userService.findAll(pageable));
    }
}
