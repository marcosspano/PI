package com.example.ProjetoIntegradorBackEnd.persistence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false,nullable = false)
    private Integer id;

    @NotBlank(message = "Nome não deve ser vazio")
    @Column(length = 100)
    @Size(min = 2, max = 100, message = "Comprimento inválido")
    private String nome;

    @NotBlank(message = "Sobrenome não deve estar vazio")
    @Column(length = 50)
    @Size(max = 50, message = "Comprimento inválido")
    private String sobrenome;

    @Email(message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Senha não deve estar vazia")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 30, message = "A senha deve conter entre 6 e 30 caracteres")
    private String senha;



    public Usuario() {

    }

}
