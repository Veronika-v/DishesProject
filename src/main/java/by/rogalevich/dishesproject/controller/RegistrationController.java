package by.rogalevich.dishesproject.controller;


import by.rogalevich.dishesproject.model.Role;
import by.rogalevich.dishesproject.model.Userr;
import by.rogalevich.dishesproject.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserrRepository userrRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Userr user, Model model){
        Userr userFromDb = userrRepository.findByUsername(user.getUsername());

        if(userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userrRepository.save(user);
        log.info("add new user  with username: "+user.getUsername()+" and userId: "+user.getId());

        return "redirect:/login";
    }
}
