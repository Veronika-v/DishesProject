package by.rogalevich.dishesproject.controller;

import by.rogalevich.dishesproject.model.OrderState;
import by.rogalevich.dishesproject.model.Orders;
import by.rogalevich.dishesproject.model.User;
import by.rogalevich.dishesproject.model.Userr;
import by.rogalevich.dishesproject.repository.DishRepository;
import by.rogalevich.dishesproject.repository.OrderRepository;
import by.rogalevich.dishesproject.repository.UserRepository;
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
public class MainController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MainController.class);
   // @Autowired // This means to get the bean called userRepository // Which is auto-generated by Spring, we will use it to handle the data
  //  private UserRepository userRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String welcome( Model model ) {
        return "welcome";
    }


    @GetMapping("/main")
    public String main(@AuthenticationPrincipal Userr userr, Model model) {
        model.addAttribute("userr", userr);
       // model.addAttribute("users", userRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
        return "main";
    }


    /*@PostMapping("/main")
    public String addNewUser ( @RequestParam  String name, @RequestParam  String password, @RequestParam  Boolean role, @RequestParam  String email, Model model) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();//(name, password, role, email);
        n.setName(name);
        n.setPassword(password);
        n.setRole(role);
        n.setEmail(email);
        userRepository.save(n);
        model.addAttribute("users", userRepository.findAll());
        return "main";
    }*/


    @PostMapping("makeOrder")
    public String filter (@AuthenticationPrincipal Userr userr, @RequestParam  String makeOrder, @RequestParam( defaultValue = "1") String countDishes , Model model) {
        if(makeOrder!=null && !makeOrder.isEmpty()) {
            Integer mOrder= parseInt(makeOrder);
            Orders o= new Orders();
            o.setDish(dishRepository.findById(mOrder));
            o.setUserr(userr);
            o.setOrderStates(Collections.singleton(OrderState.MORDER));
            o.setCount_of_dishes(parseInt(countDishes));
            orderRepository.save(o);
        }
        else
            model.addAttribute("message", "Enter the dish ID");
        return "redirect:/main";
    }

    @PostMapping("filter")
    public String filter (@AuthenticationPrincipal Userr userr, @RequestParam String filter, Model model) {
        if(filter!=null && !filter.isEmpty() )
            model.addAttribute("dishes", dishRepository.findByDishname(filter));
        else
            model.addAttribute("dishes", dishRepository.findAll());
        model.addAttribute("userr", userr);
        return "main";
    }
}


