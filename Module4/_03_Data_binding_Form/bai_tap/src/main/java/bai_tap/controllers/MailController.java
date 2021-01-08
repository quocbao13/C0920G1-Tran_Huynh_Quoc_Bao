package bai_tap.controllers;

import bai_tap.models.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {

    @GetMapping(value = "")
    public String showForm(Model model) {
        model.addAttribute("mail", new Mail());
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages", languages);
        List<String> spamsFilters = new ArrayList<>();
        spamsFilters.add("25");
        spamsFilters.add("50");
        spamsFilters.add("75");
        spamsFilters.add("100");
        model.addAttribute("spamsFilters", spamsFilters);
        return "index";
    }

    @PostMapping(value = "/up")
    public String upForm(@ModelAttribute Mail mail, Model model) {
        model.addAttribute("mail" , mail);
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("languages", languages);
        List<String> spamsFilters = new ArrayList<>();
        spamsFilters.add("25");
        spamsFilters.add("50");
        spamsFilters.add("75");
        spamsFilters.add("100");
        model.addAttribute("spamsFilters", spamsFilters);
        return "info";
    }
}
