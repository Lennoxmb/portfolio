package com.example.portfolio.controllers;

import com.example.portfolio.models.User;
import com.example.portfolio.repositories.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserRepo usersDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepo usersDao, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.usersDao = usersDao;

    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/home")
    public String GoHome(){
        return "index";
    }

    @GetMapping("/projectList")
    public String projectList() {return "projectList";}

    @GetMapping("/pizzaProject")
    public String pizzaProject(){
        return "pizzaProject";
    }

    @GetMapping("/codeupProject")
    public String codeupProject(){
        return "codeupProject";
    }

    @GetMapping("/coffeeProject")
    public String coffeeProject(){
        return "coffeeProject";
    }

    @GetMapping("/konamiProject")
    public String konamiProject(){return "KonamiProject";}

    @GetMapping("/weathermap")
    public String weathermap(){return "weathermap";}

    @GetMapping("/movieproject")
    public String movieproject(){return "movieproject";}


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username,
                               @RequestParam(name="email") String email,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "passwordConfirmation") String passwordConfirm){
        if(password.equals(passwordConfirm)){
            password = passwordEncoder.encode(password);
            usersDao.save(new User(email, username, password));
            return "redirect:/login";
        } else {
            return "redirect:/register";
        }
    }


}
