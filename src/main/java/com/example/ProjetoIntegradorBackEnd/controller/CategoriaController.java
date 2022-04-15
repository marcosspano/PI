package com.example.ProjetoIntegradorBackEnd.controller;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Categoria;
import com.example.ProjetoIntegradorBackEnd.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> getAllCategoria(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoriaById(@PathVariable Integer id){
        service.deleteById(id);
        return "Categoria deletada com sucesso!";
    }

    @PostMapping
    public Categoria postCategoria(@RequestBody Categoria categoria){
        return service.create(categoria);
    }

    @PutMapping
    public Categoria putCategoria(@RequestBody Categoria categoria){
        return service.update(categoria);
    }
}
