package com.academia2.deportes.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia2.deportes.entity.Deporte;
import com.academia2.deportes.service.DeporteService;

@RestController 
@RequestMapping("api/deportes")
public class DeporteController {
    
    private final DeporteService deporteService;

    public DeporteController(DeporteService deporteService){
        this.deporteService = deporteService;
    }

    @PostMapping 
    public Deporte crearDeporte(@RequestBody  Deporte deporte){
        return deporteService.crear(deporte);
    }

    @GetMapping 
    public List<Deporte> listarDeportes(){
        return deporteService.obtenerTodos();
    }
    

}