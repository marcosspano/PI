package com.example.ProjetoIntegradorBackEnd.controller;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Cidade;
import com.example.ProjetoIntegradorBackEnd.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public List<Cidade> getCidade(){
        return service.findAll();
    }

    @PostMapping
    public Cidade postCidade(@RequestBody Cidade cidade){
        return service.createCidade(cidade);
    }
}
