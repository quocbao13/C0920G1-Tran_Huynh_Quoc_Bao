package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.standard.Media;


@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = {"","/"})
    public String showList(Pageable pageable, Model model) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "blogs/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Blog blog, Model model) {
        model.addAttribute("blog", blog);
        return "blogs/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.findOne(id);
        model.addAttribute("blog", blog);
        return "blogs/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/";
    }

    @GetMapping(value = "/delete/{id}")
    public String showDelete(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.findOne(id);
        model.addAttribute("blog", blog);
        return "blogs/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:/blog/";
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> searchByContent(@RequestParam(value = "search", required = false) String search, Model model, Pageable pageable) {
        Page<Blog> blogList;
        if (search != null && !search.equals("")) {
            blogList = blogService.findByContentContaining(search, pageable);
        }else {
            blogList = blogService.findAll(pageable);
        }
        model.addAttribute("blogList", blogList);
        return blogList;
    }
}
