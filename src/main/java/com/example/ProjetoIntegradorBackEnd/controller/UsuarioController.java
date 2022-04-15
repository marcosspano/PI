package com.example.ProjetoIntegradorBackEnd.controller;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Usuario;
import com.example.ProjetoIntegradorBackEnd.responses.Response;
import com.example.ProjetoIntegradorBackEnd.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getUsuario() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastro(@Valid @RequestBody Usuario usuario) {
        return service.cadastro(usuario);
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(String email, String senha) {
        return service.validarSenha(email, senha);
    }
}
