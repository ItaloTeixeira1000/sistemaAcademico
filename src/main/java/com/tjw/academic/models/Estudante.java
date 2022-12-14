package com.tjw.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "estudante")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "matricula")
    private String matricula;

    private String email;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;

    private String telefone;

    @ManyToMany
    private List<Disciplina> disciplinas;

}
