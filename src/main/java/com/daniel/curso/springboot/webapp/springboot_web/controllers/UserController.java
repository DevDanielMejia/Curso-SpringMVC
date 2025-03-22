package com.daniel.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.daniel.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Daniel", "Mejia");
        user.setEmail("df@gmail");
        model.addAttribute("tittle", "Hola mundo Spring Boot");
        model.addAttribute("user", user); 
        return "details";
    } 

    @GetMapping("/details2")
    public String details2(Map<String, Object> model){
        model.put("tittle", "Hola mundo Spring Boot");
        model.put("name", "Daniel");
        model.put("lastname", "Rodriguez");
        return "details";
    } 

    @GetMapping("list")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("tittle", "Listado de usuarios");
        return "list";
    }

    //Se guarda el objeto users en la vista, reutilizar datos
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
            new User ("Josue", "Roe", "jouse@"),
            new User ("Lalo", "Fae"),
            new User ("JoSdasue", "Dae", "JoS@correo"),
            new User ("DASDAe", "GeA")
        );
    }
    
}
