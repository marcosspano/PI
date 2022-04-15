package com.example.ProjetoIntegradorBackEnd.service;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Produto;
import com.example.ProjetoIntegradorBackEnd.persistence.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Integer id){
        return repository.findById(id).get();
    }

    public Produto createProduto(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> findByCidade(String cidade){
        return repository.findByCidade(cidade);
    }

    public List<Produto> findByCategoria(String categoria){
        return repository.findByCategoria(categoria);
    }

    public List<Produto> listarProdutoByCidade(Integer id){
        return repository.findByCity(id);
    }

    public List<Produto> listarProdutoByDate(Integer id, LocalDate inicio, LocalDate fim){
        return repository.findByDateAndCity(id,inicio,fim);
    }
}
