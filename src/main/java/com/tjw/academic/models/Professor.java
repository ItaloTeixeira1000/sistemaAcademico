package com.tjw.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String rg;

    private String email;

    private String telefone;

    private String cpf;

    @ManyToMany
    private List<Disciplina> disciplinas;
}
