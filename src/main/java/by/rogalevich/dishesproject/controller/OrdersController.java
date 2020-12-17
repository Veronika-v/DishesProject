package by.rogalevich.dishesproject.controller;

import by.rogalevich.dishesproject.model.*;
import by.rogalevich.dishesproject.repository.DishRepository;
import by.rogalevich.dishesproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

import static java.lang.Integer.parseInt;


@Controller
public class OrdersController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/orders")
    public String AcceptOrder( @RequestParam String order_id, Model model){
        Orders order =orderRepository.findById(parseInt(order_id));
        if(order.getOrderStates().equals(Collections.singleton(OrderState.MORDER)))
        {
            order.setOrderStates(Collections.singleton(OrderState.GORDER));
            orderRepository.save(order);
        }
        else
            model.addAttribute("message", "This order had accepted before");
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @GetMapping("/orders")
    public String getOrdersList(@AuthenticationPrincipal Userr userr, Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }
}
