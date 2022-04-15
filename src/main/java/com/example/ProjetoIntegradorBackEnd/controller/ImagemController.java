package com.example.ProjetoIntegradorBackEnd.controller;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Imagem;
import com.example.ProjetoIntegradorBackEnd.persistence.entities.Produto;
import com.example.ProjetoIntegradorBackEnd.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/imagem")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class ImagemController {

    @Autowired
    private ImagemService service;

    @GetMapping
    public List<Imagem> getImagem(){
        return service.findAll();
    }

    @GetMapping("/{produto}")
    public List<Imagem> getImagemByProduto(@PathVariable String produto){
        return service.findByProduto(produto);
    }

    @GetMapping("/produto/{produtoID}")
    public List<Imagem> getImagemByProdutoID(@PathVariable Integer produtoID) {
        return service.findByProdutoID(produtoID);
    }


}
