package com.example.thymeleaf_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @GetMapping("/hello")
    public String greeting(Model model) {
        model.addAttribute("name", "Thymeleaf!");
        return "greeting"; // This will resolve to src/main/resources/templates/greeting.html
    }

}
