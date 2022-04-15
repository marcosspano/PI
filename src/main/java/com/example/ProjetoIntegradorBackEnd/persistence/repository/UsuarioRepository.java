package com.example.ProjetoIntegradorBackEnd.persistence.repository;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByEmail(String email);

}
