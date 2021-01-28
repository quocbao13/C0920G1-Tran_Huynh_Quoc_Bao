package com.codegym.controller.admin;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.User;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping(value = {"","/"})
    public String showList(Model model, Pageable pageable) {
        model.addAttribute("customerList", customerService.findAll(pageable));
        return "admin/customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("titleModal", "Create");
        return "admin/customer/create";
    }

    @PostMapping(value = "/create")
    public String create( @ModelAttribute Customer customer ) {
        customerService.save(customer);
        return "redirect:/admin/customer/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("titleModal", "Edit");
        return "admin/customer/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/admin/customer/";
    }

    @GetMapping(value = "/delete/{id}")
    public String showDelete(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("titleModal", "Delete");
        return "admin/customer/delete";
    }

    @GetMapping(value = "/actionDelete/{id}")
    public String delete(@PathVariable("id") Long id, Pageable pageable, Model model) {
        customerService.delete(id);
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "admin/customer/search";
    }

    @GetMapping(value = "/search")
    public String search(Pageable pageable, Model model, @RequestParam("search") String searchName) {
        Page<Customer> customerList = customerService.findAllByCustomer_nameContaining( pageable, searchName);
        model.addAttribute("customerList", customerList);
        return "admin/customer/search";
    }

    @GetMapping(value = "/detail/{id}")
    public String showInfo(@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("titleModal", "Detail");
        return "admin/customer/detail";
    }
}
