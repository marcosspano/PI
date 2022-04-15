package com.example.ProjetoIntegradorBackEnd.persistence.repository;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Imagem;
import com.example.ProjetoIntegradorBackEnd.persistence.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

    @Query("select i from Imagem i where i.produto.nome = ?1")
    List<Imagem> findByProduto(String produto);

    @Query("select i from Imagem i where i.produto.id = ?1")
    List<Imagem> findByProdutoID(Integer produtoID);

}
