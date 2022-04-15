package com.example.ProjetoIntegradorBackEnd.controller;

import com.example.ProjetoIntegradorBackEnd.persistence.entities.Reserva;
import com.example.ProjetoIntegradorBackEnd.persistence.entities.Usuario;
import com.example.ProjetoIntegradorBackEnd.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> getReserva() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public List<Reserva> getReservaByProduto(@PathVariable Integer id){
        return service.findByProdutoId(id);
    }

    @PostMapping
    public Reserva postReserva(@RequestBody Reserva reserva){
        return service.createReserva(reserva);
    }
}
