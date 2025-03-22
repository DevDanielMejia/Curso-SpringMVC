package com.daniel.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.curso.springboot.webapp.springboot_web.models.User;
import com.daniel.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/var1/{message}")
    public ParamDTO var1(@PathVariable() String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);
        return paramDTO;
    }

    @GetMapping("/var2/{product}/{id}")
    public Map<String, Object> var2(@PathVariable() String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody() User user) {
        return user;
    }
    
    
    
}
