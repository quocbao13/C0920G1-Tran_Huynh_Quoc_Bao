package com.codegym.controller.admin;

import com.codegym.model.Contract;
import com.codegym.model.Employee;
import com.codegym.model.User;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(value = "/admin/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @GetMapping(value = {"","/"})
    public String showList(Model model, Pageable pageable){
        model.addAttribute("contractList", contractService.findAll(pageable));
        return "admin/contract/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", serviceService.findAll());
        return "admin/contract/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Contract contract, Principal principal) {
        String userName = principal.getName();
        User user = userService.findByUserName(userName);
        Employee employee = user.getEmployees().get(0);
        contract.setEmployee(employee);
        contractService.save(contract);
        return "redirect:/admin/contract/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model){
        Contract contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", serviceService.findAll());
        return "admin/contract/edit";
    }
}
