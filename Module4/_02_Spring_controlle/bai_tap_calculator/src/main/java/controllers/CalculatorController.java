package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String show(){
        return "index";
    }

    @PostMapping("/relay")
    public String relayAns(@RequestParam int num1, @RequestParam int num2,
                           @RequestParam String ans, RedirectAttributes redirectAttributes) {
        double result = 0;
        switch (ans) {
            case "Addition" : result = num1 + num2;
                break;
            case "Subtraction" : result = num1 - num2;
                break;
            case "Multiplication" : result = num1 * num2;
                break;
            case "Division" : result = num1 / num2;
                break;
        }
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }
}
