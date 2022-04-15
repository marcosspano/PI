package com.example.ProjetoIntegradorBackEnd.service;

import com.example.ProjetoIntegradorBackEnd.exception.DBException;
import com.example.ProjetoIntegradorBackEnd.persistence.entities.Usuario;
import com.example.ProjetoIntegradorBackEnd.persistence.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private final PasswordEncoder encoder;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Usuario cadastro(Usuario usuario) {
        boolean emailEmUso = repository.findByEmail(usuario.getEmail())
                .stream()
                .anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

        if(emailEmUso) {
            throw new DBException("Usuário existente.");
        }

        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }


    public ResponseEntity<Boolean> validarSenha(@RequestParam String email, @RequestParam String senha) {
        Optional<Usuario> optUsuario = repository.findByEmail(email);
        if(optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();
        boolean valid = encoder.matches(senha, usuario.getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
