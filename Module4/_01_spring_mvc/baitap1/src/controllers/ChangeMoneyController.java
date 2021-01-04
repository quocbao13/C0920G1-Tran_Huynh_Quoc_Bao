package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {

    @GetMapping("/change")
    public String Change(@RequestParam String usa, Model model){
        double vnd = Double.parseDouble(usa) * 25000;
        model.addAttribute("vnd", vnd);
        return "changeMoney";
    }
}
