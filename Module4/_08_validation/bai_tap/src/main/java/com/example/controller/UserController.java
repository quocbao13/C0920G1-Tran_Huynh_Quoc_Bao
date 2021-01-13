package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"","/"})
    public ModelAndView showList(Pageable pageable){
        return new ModelAndView("users/index", "userList", userService.findAll(pageable));
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreate(User user) {
        return new ModelAndView("users/create", "user", user);
    }

    @PostMapping(value = "/create")
    public String create(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "users/create";
        }else {
            return "redirect:/";
        }
    }
}
