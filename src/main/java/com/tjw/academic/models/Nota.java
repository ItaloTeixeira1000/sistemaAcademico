package com.tjw.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Estudante estudante;

    private Double pontuacao;
}
