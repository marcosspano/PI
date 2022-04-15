package com.example.ProjetoIntegradorBackEnd.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false)
    private Integer id;
    private String nome;
    private String pais;
}
