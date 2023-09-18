package com.example.portfolio.controllers;

import com.example.portfolio.models.User;
import com.example.portfolio.repositories.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


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

    @GetMapping("/profile")
    public String profile(){
        return "profile";
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
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("loginError", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        return "redirect:/profile";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name = "username") String username,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "passwordConfirmation") String passwordConfirm,
                               RedirectAttributes redirectAttributes,
                               HttpServletRequest request) {

        String defaultAvatar = "https://cdn.filestackcontent.com/6Vs83AuzQoW2tCNsAB17";
        String defaultBackground = "https://cdn.filestackcontent.com/yhkFzlgzQtejKwLdOo51";
        User existingUser = usersDao.findUserByUsername(username);
        User existingEmail = usersDao.findUserByEmail(email);

        if (existingUser != null || existingEmail != null) {
            redirectAttributes.addAttribute("userExists", true);
            return "redirect:/register?error";
        }

        if (password.equals(passwordConfirm)) {
            password = passwordEncoder.encode(password);
            usersDao.save(new User(username, email, password, defaultAvatar, defaultBackground, 0));
            return "redirect:/login";
        } else {
            redirectAttributes.addAttribute("passwordMismatch", true);
            return "redirect:/register?error";
        }
    }
    }

