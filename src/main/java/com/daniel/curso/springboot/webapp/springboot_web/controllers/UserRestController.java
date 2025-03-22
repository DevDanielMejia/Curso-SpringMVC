package com.daniel.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.daniel.curso.springboot.webapp.springboot_web.models.User;
import com.daniel.curso.springboot.webapp.springboot_web.models.dto.UserDTO;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDTO details(Model model){
        UserDTO userDTO = new UserDTO();
        User user = new User("Daniel", "Mejia");
        userDTO.setUser(user);
        userDTO.setTittle("Hola mundo Spring Boot2");
        return userDTO;
    }

    @GetMapping("/list")  
    public List<User> list(){
        User user1 = new User("Daniel", "Mejia");
        User user2 = new User("Felipe", "Lopez");
        User user3 = new User("Juan", "Doe");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<User> users2 = Arrays.asList(user1,user2,user3);
        return users2;
    }


    @GetMapping("/details-map")
    public Map <String,Object> detailsMap(Model model){
        User user = new User("Daniel", "Mejia");
        Map <String,Object> body = new HashMap<>();
        body.put("tittle", "Hola mundo Spring Boot");
        body.put("user", user);
        return body;
    } 
}
