package com.academia2.deportes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia2.deportes.entity.Categoria;
import com.academia2.deportes.service.CategoriaService;

@RestController 
@RequestMapping("api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping 
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.crear(categoria);
    }

    @GetMapping 
    public List<Categoria> listarCategorias(){
        return categoriaService.obtenerTodos();
    }





}
