package com.example.portfolio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class userController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }



}
