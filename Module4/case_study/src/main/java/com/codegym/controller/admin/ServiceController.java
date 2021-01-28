package com.codegym.controller.admin;

import com.codegym.model.Customer;
import com.codegym.model.Service;
import com.codegym.service.RentTypeService;
import com.codegym.service.ServiceService;
import com.codegym.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @GetMapping(value = {"","/"})
    public String showList(Model model, Pageable pageable) {
        model.addAttribute("serviceList", serviceService.findAll(pageable));
        return "admin/service/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("titleModal", "Create");
        return "admin/service/create";
    }

    @PostMapping(value = "/create")
    public String create( @ModelAttribute Service service) {
        serviceService.save(service);
        return "redirect:/admin/service/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("titleModal", "Edit");
        return "admin/service/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Service service) {
        serviceService.save(service);
        return "redirect:/admin/service/";
    }

    @GetMapping(value = "/delete/{id}")
    public String showDelete(Model model, @PathVariable Long id) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        model.addAttribute("titleModal", "Delete");
        return "admin/service/delete";
    }

    @GetMapping(value = "/actionDelete/{id}")
    public String delete(@PathVariable("id") Long id, Pageable pageable, Model model) {
        serviceService.delete(id);
        Page<Service> serviceList = serviceService.findAll(pageable);
        model.addAttribute("serviceList", serviceList);
        return "admin/service/search";
    }

    @GetMapping(value = "/search")
    public String search(Pageable pageable, Model model, @RequestParam("search") String searchName) {
        Page<Service> serviceList = serviceService.findAllByServiceNameContaining( pageable, searchName);
        model.addAttribute("serviceList", serviceList);
        return "admin/service/search";
    }

    @GetMapping(value = "/detail/{id}")
    public String showInfo(@PathVariable("id") Long id, Model model) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        model.addAttribute("titleModal", "Detail");
        return "admin/service/detail";
    }
}
