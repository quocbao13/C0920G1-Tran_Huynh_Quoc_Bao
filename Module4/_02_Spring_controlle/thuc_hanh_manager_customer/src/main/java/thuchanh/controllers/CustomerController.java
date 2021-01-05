package thuchanh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thuchanh.models.Customer;
import thuchanh.services.CustomerService;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        List<Customer> customerList = customerService.selectAll();
        return new  ModelAndView("customers/list", "customerList", customerList);
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(
            @RequestParam int id,
            @RequestParam String name
    ) {
        Customer customer = new Customer(id, name);
        customerService.update(customer);
        return "redirect:/customers";
    }
}
