package com.daniel.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.curso.springboot.webapp.springboot_web.models.User;
import com.daniel.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("${config.code}")
    private Integer code;
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.price}")
    private long price;

    @Autowired 
    private Environment environment;

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
    
    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.message}") String message) {
        Map<String,Object> json = new HashMap<>();
        Long code2 = environment.getProperty("config.code", long.class);
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", code2);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
    
    
    
}
