package com.Nanas.demo.infraestructura.adaptadores.web.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "API NANAS funcionando correctamente";
    }
}