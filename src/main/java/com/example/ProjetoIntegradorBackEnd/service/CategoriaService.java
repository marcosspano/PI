package com.example.ProjetoIntegradorBackEnd.service;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Categoria;
import com.example.ProjetoIntegradorBackEnd.persistence.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Integer id){
        return repository.findById(id).get();
    }

    public Categoria create(Categoria categoria){
        return repository.save(categoria);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Categoria update(Categoria categoria){
        Categoria categoriaEdit = repository.getById(categoria.getId());
        categoriaEdit.setDescricao(categoria.getDescricao());
        categoriaEdit.setTitulo(categoria.getTitulo());
        categoriaEdit.setUrlImagem(categoria.getUrlImagem());
        return repository.save(categoriaEdit);
    }
}
