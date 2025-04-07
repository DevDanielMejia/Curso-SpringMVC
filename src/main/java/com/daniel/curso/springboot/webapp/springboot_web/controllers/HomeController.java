package com.daniel.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping({"","/","/home"})
    public String home() {

        return "redirect:/details";
        // return "forward:/details"
    }
    
}
