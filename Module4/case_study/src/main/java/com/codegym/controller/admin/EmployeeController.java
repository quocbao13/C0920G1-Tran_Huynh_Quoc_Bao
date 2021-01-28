package com.codegym.controller.admin;

import com.codegym.model.Employee;
import com.codegym.model.User;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    PositionService positionService;

    @Autowired
    UserService userService;

    @GetMapping({"","/"})
    public String showList(Model model, Pageable pageable) {
        model.addAttribute("employeeList", employeeService.findAll(pageable));
        return "admin/employee/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("titleModal", "Create");
        return "admin/employee/create";
    }

    @PostMapping(value = "/create")
    public String create( @ModelAttribute Employee employee ) {
        User user = userService.findByUserName(employee.getUser().getUsername());
        employee.setUser(user);
        employeeService.save(employee);
        return "redirect:/admin/employee/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("titleModal", "Edit");
        return "admin/employee/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Employee employee) {
        User user = userService.findByUserName(employee.getUser().getUsername());
        employee.setUser(user);
        employeeService.save(employee);
        return "redirect:/admin/employee/";
    }

    @GetMapping(value = "/delete/{id}")
    public String showDelete(Model model, @PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("titleModal", "Delete");
        return "admin/employee/delete";
    }

    @GetMapping(value = "/actionDelete/{id}")
    public String delete(@PathVariable("id") Long id, Pageable pageable, Model model) {
        employeeService.delete(id);
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "admin/employee/search";
    }

    @GetMapping(value = "/search")
    public String search(Pageable pageable, Model model, @RequestParam("search") String searchName) {
        Page<Employee> employeeList = employeeService.findAllByEmployeeNameContaining(searchName, pageable);
        model.addAttribute("employeeList", employeeList);
        return "admin/employee/search";
    }

    @GetMapping(value = "/detail/{id}")
    public String showInfo(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("titleModal", "Detail");
        return "admin/employee/detail";
    }
}
