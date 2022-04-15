package com.example.ProjetoIntegradorBackEnd.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false)
    private Integer id;

    private LocalTime horaReserva;
    private LocalDate inicioReserva;
    private LocalDate fimReserva;

    @ManyToOne
    @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "fk_produto"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "fk_usuario"))
    private Usuario usuario;
}
