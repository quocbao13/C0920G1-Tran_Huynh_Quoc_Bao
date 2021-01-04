package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {

    @GetMapping("/translate")
    public String ShowTranslate() {
        return "translate";
    }

    @GetMapping("/ans")
    public String ShowAns(@RequestParam String eng, Model model) {
        String vn;
        switch (eng){
            case "house": vn = "nhà";
                break;
            case "dog": vn = "chó";
                break;
            case "cat": vn = "mèo";
                break;
            default: vn = "Don't find";
                break;
        }
        model.addAttribute("vn", vn);
        return "translate";
    }

}
