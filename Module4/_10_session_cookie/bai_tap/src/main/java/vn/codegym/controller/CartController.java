package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Cart;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.HashMap;

@Controller
@SessionAttributes("carts")
public class CartController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/addCart/{id}")
    public String addCart(@PathVariable Long id, @SessionAttribute("carts") HashMap<Long, Cart> carts, Model model, Pageable pageable) {
        HashMap<Long, Cart> cartList = carts;
        if (cartList == null) {
            cartList = new HashMap<>();
        }
        Product product = productService.findOne(id);
        if (product != null){
            if (cartList.containsKey(id)){
                Cart item = cartList.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity()+1);
            }else {
                Cart item = new Cart(product, 1);
                cartList.put(id, item);
            }
        }
        model.addAttribute("carts", cartList);
        model.addAttribute("cartNum", cartList.size());
        model.addAttribute("productList", productService.findAll(pageable));
        return "product/index";
    }

    @GetMapping("/showCart")
    public String showCart(@SessionAttribute("carts") HashMap<Long, Cart> carts, Model model) {
        String message = "";
        if (carts == null) {
            message = "Cart is null!";
        }
        model.addAttribute("messageCart", message);
        model.addAttribute("carts", carts);
        return "cart/showCart";
    }
}
