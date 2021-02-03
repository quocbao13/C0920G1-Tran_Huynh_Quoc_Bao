package com.example.controller;

import com.example.model.Question;
import com.example.model.User;
import com.example.repository.QuestionRepository;
import com.example.repository.QuestionTypeRepository;
import com.example.service.QuestionService;
import com.example.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionTypeService questionTypeService;

    @GetMapping(value = {"/",""})
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("questionList", questionService.findAll(pageable));
        return "home";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        return "create";
    }

    @PostMapping(value = "/create")
    public String create(@Validated @ModelAttribute Question question, BindingResult bindingResult, Principal principal, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("question",question);
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            return "/create";
        }
        question.setStatus("No Answer");
        question.setUser_create(principal.getName());
        questionService.save(question);
        return "redirect:/";
    }

    @GetMapping(value = "/answer/{id}")
    public String showQuestion(@PathVariable("id") Long id, Model model) {
        Question question = questionService.findOne(id);
        model.addAttribute("question", question);
        return "answer";
    }

    @PostMapping(value = "/answer")
    public String answer(@ModelAttribute Question question, Principal principal) {
        question.setStatus("Have Answer");
        question.setUser_feedback(principal.getName());
        questionService.save(question);
        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public String search(Pageable pageable, Model model, @RequestParam("search") String searchName) {
        Page<Question> questionList = questionService.findByTitleContaining( pageable, searchName);
        model.addAttribute("questionList", questionList);
        return "search";
    }

    @GetMapping(value = "/detail/{id}")
    public String showInfo(@PathVariable("id") Long id, Model model) {
        Question question = questionService.findOne(id);
        model.addAttribute("question", question);
        model.addAttribute("titleModal", "Detail");
        return "detail";
    }

    @GetMapping(value = "/delete/{id}")
    public String showDelete(Model model, @PathVariable Long id) {
        Question question = questionService.findOne(id);
        model.addAttribute("question", question);
        model.addAttribute("titleModal", "Delete");
        return "delete";
    }
}
