package com.daniel.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;
import com.daniel.curso.springboot.webapp.springboot_web.models.dto.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/rute")
    public ParamDTO rute(@RequestParam(required = false, defaultValue = "Mensaje defecto") String message) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);
        return paramDTO;
    }
    
    @GetMapping("/rute2")
    public ParamMixDTO rute2(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDTO paramsDTO = new ParamMixDTO();
        paramsDTO.setMessage(text);
        paramsDTO.setCode(code);
        return paramsDTO;
    }

    @GetMapping("/rute3")
    public ParamMixDTO rute3(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }
        ParamMixDTO paramsDTO = new ParamMixDTO();
        paramsDTO.setMessage(request.getParameter("message"));
        paramsDTO.setCode(code);
        return paramsDTO;
    }
    
    
}
