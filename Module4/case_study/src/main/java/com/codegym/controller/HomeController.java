package com.codegym.controller;

import com.codegym.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    ServiceService serviceService;

    @GetMapping(value = "/")
    public String showHome(){
        return "a";
    }
}
