package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.repository.RoleRepository;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping({"/register"})
    public String showRegister(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roleList", roleRepository.findAll());
        return "login/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        user.setEnabled(true);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userRepository.save(user);
        return "redirect:/login";
    }
}
