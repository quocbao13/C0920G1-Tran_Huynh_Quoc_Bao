package com.codegym.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping(value = {"/",""})
    public String showAdmin() {
        return "admin/layoutAdmin";
    }
}
