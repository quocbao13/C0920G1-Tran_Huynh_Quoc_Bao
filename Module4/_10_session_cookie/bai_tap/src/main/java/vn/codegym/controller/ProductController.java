package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.Cart;
import vn.codegym.service.ProductService;

import java.util.HashMap;

@Controller
@SessionAttributes("carts")
public class ProductController {

    @Autowired
    ProductService productService;

    @ModelAttribute("carts")
    public HashMap<Long, Cart> getCartList () {
        return new HashMap<>();
    }

    @GetMapping("/")
    public String showList(Model model, Pageable pageable, @ModelAttribute("carts") HashMap<Long, Cart> carts) {
        model.addAttribute("carts", carts);
        model.addAttribute("cartNum", carts.size());
        model.addAttribute("productList", productService.findAll(pageable));

        return "product/index";
    }
}
