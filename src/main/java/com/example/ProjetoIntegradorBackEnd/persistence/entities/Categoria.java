package com.example.ProjetoIntegradorBackEnd.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter@Getter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false)
    private Integer id;

    @Column(unique = true)
    private String titulo;

    @Lob
    private String descricao;
    @Lob
    private String urlImagem;
}
