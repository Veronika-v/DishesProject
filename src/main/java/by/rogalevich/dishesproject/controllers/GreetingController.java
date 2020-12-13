package by.rogalevich.dishesproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Model model
    ) {
        model.addAttribute("name", name);
        return "welcome";
    }

    @GetMapping
    public String main(Model model)
    {
        model.addAttribute("some", "Welcome to the main page!");
        return "main";
    }
}


