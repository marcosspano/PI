package com.example.ProjetoIntegradorBackEnd.persistence.repository;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
}
