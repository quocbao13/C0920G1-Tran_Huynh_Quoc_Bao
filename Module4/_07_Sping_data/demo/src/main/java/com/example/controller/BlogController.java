package com.example.controller;

import com.example.model.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView listBlog(Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Blog> blogList;
        if (search.isPresent()) {
            blogList = blogService.findAllByFirstNameContaining(search.get(), pageable);
        }else {
            blogList = blogService.findAll(pageable);
        }
        return new ModelAndView("blog/list", "blogList", blogList);
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("blog/create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/";
    }
}
