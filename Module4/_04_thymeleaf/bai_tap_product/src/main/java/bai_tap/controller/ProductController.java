package bai_tap.controller;

import bai_tap.model.Product;
import bai_tap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("list", "products", productService.findAll());
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @Autowired
    ServletContext context;

    @PostMapping(value = "/save")
    public String save(Product product, Model model) {
        try {
            MultipartFile multipartFile = product.getImgProduct();
            model.addAttribute("message", "upload success");
            String filename = multipartFile.getOriginalFilename();
            File file = new File("/WEB-INF/img", filename);
            multipartFile.transferTo(file);
            product.setIdProduct((int)(Math.random() * 10000));
            productService.save(product);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "upload failed");
        }
        return "redirect:/";
    }

}
