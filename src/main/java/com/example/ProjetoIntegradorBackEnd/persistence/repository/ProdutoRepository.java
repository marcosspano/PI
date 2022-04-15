package com.example.ProjetoIntegradorBackEnd.persistence.repository;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query("select p from Produto p where p.cidade.nome = ?1")
    List<Produto> findByCidade(String cidade);

    @Query("select p from Produto p where p.categoria.descricao = ?1")
    List<Produto> findByCategoria(String categoria);

    @Query("select p from Reserva r join Produto p on r.produto.id = p.id where p.cidade.id = ?1 and r.inicioReserva >= ?2 and r.fimReserva <= ?3")
    List<Produto> findByDateAndCity(Integer cidadeID, LocalDate iniciReserva, LocalDate fimReserva);

    @Query("select p from Reserva r join Produto p on r.produto.id = p.id where p.cidade.id = ?1")
    List<Produto> findByCity(Integer cidadeID);
}
