package by.rogalevich.dishesproject.controller;


import by.rogalevich.dishesproject.model.Category;
import by.rogalevich.dishesproject.model.Dishes;
import by.rogalevich.dishesproject.model.Role;
import by.rogalevich.dishesproject.model.Userr;
import by.rogalevich.dishesproject.repository.DishRepository;
import by.rogalevich.dishesproject.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @PostMapping("/dish")
    public String addUser(Dishes dish, Model model){


        dishRepository.save(dish);
        return "redirect:/main";
    }

    @GetMapping("/dish")
    public String main(@AuthenticationPrincipal Userr userr, Model model) {
        //if(userr.getRoles()!=Collections.singleton(Role.ADMIN)){
          //  model.addAttribute("message", "If you want add dishes you have to be an ADMIN");
          //  return "login";
        //}
        return "dish";
    }
}
