package com.example.ProjetoIntegradorBackEnd.service;

import com.example.ProjetoIntegradorBackEnd.data.DetalheUsuarioData;
import com.example.ProjetoIntegradorBackEnd.persistence.entities.Usuario;
import com.example.ProjetoIntegradorBackEnd.persistence.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class DetalheUsuarioServiceimpl implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = repository.findByEmail(username);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }

}
