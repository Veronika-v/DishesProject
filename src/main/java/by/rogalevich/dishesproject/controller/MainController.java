package by.rogalevich.dishesproject.controller;

import by.rogalevich.dishesproject.model.User;
import by.rogalevich.dishesproject.model.Userr;
import by.rogalevich.dishesproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired // This means to get the bean called userRepository // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome( Model model ) {
        return "welcome";
    }


    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String addNewUser (@AuthenticationPrincipal Userr userr, @RequestParam  String name, @RequestParam  String password, @RequestParam  Boolean role, @RequestParam  String email, Model model) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User(name, password, role, email, userr);
        /*n.setName(name);
        n.setPassword(password);
        n.setRole(role);
        n.setEmail(email);*/
        userRepository.save(n);
        model.addAttribute("users", userRepository.findAll());
        return "main";
    }

    @PostMapping("filter")
    public String filter (@RequestParam  String filter, Model model) {
        if(filter!=null && !filter.isEmpty() )
            model.addAttribute("users", userRepository.findByName(filter));
        else
             model.addAttribute("users", userRepository.findAll());
        return "main";
    }
}


