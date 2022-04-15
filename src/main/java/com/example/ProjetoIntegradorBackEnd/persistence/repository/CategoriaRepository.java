package com.example.ProjetoIntegradorBackEnd.persistence.repository;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
