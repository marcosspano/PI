package com.example.ProjetoIntegradorBackEnd.service;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Cidade;
import com.example.ProjetoIntegradorBackEnd.persistence.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> findAll(){
        return repository.findAll();
    }

    public Cidade createCidade(Cidade cidade){
        return repository.save(cidade);
    }
}
