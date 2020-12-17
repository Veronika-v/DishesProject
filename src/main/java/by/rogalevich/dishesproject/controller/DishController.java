package by.rogalevich.dishesproject.controller;


import by.rogalevich.dishesproject.model.*;
import by.rogalevich.dishesproject.repository.DishRepository;
import by.rogalevich.dishesproject.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

import static java.lang.Integer.parseInt;

@Controller
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @PostMapping("/dish")
    public String addDish(Dishes dish, Model model){
        dishRepository.save(dish);
        model.addAttribute("dishes", dishRepository.findAll());
        return "dish";
    }

    @PostMapping("/dish_delete")
    public String deleteDish(@RequestParam String dish_id, Model model){

        Dishes dish= dishRepository.findById(parseInt(dish_id));
        dishRepository.delete(dish);
        model.addAttribute("dishes", dishRepository.findAll());
        return "dish";
    }

    @GetMapping("/dish")
    public String main( Model model) {

        model.addAttribute("dishes", dishRepository.findAll());
        return "dish";
    }
}
