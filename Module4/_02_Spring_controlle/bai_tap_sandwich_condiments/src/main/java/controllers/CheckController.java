package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CheckController {

    @PostMapping("/save")
    public String save(@RequestParam(required = false, name = "condiment") String[] condiment, RedirectAttributes redirectAttributes) {
        String ans = "";
        if (condiment != null) {
            for (String s : condiment) {
                ans += s + ", ";
            }
        } else {
            ans = "null";
        }
        redirectAttributes.addFlashAttribute("ans", ans);
        return "redirect:/";
    }

    @GetMapping("/")
    public String show() {
        return "index";
    }
}
