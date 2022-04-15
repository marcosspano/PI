package com.example.ProjetoIntegradorBackEnd.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false,nullable = false)
    private Integer id;

    @NotBlank(message = "Nome não deve estar vazio")
    private String nome;

    @Lob
    @NotBlank(message = "Descrição não deve estar vazio")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "fk_cidade"))
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "fk_categoria"))
    private Categoria categoria;

    @ManyToMany
    @JoinTable(name = "produtos_tem_caracteristica", joinColumns = {@JoinColumn(name = "produto_id")}, inverseJoinColumns = {@JoinColumn(name = "caracteristica_id")})
    private List<Caracteristica> caracteristicas;

    public Produto() {

    }
}
