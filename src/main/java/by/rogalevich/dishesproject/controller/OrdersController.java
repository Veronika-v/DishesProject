package by.rogalevich.dishesproject.controller;

import by.rogalevich.dishesproject.model.Dishes;
import by.rogalevich.dishesproject.model.Role;
import by.rogalevich.dishesproject.model.Userr;
import by.rogalevich.dishesproject.repository.DishRepository;
import by.rogalevich.dishesproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class OrdersController {
    @Autowired
    private OrderRepository orderRepository;

    //@PostMapping("/orders")
   //public String addUser(Dishes dish, Model model){

        //orderRepository.save(dish);
    //    return "redirect:/main";
    //}

    @GetMapping("/orders")
    public String main(@AuthenticationPrincipal Userr userr, Model model) {
        if(userr.getRoles()!= Collections.singleton(Role.ADMIN)){
            model.addAttribute("message", "If you want check orders you have to be an ADMIN");
            return "login";
        }
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }
}
