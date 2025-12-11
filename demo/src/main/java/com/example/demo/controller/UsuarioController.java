package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @GetMapping("/api/hola")
    public String hola() {
        return "Hola";
    }

    @GetMapping("/api/adios")
    public String home() {
        return "Adios";
    }
}