package com.tjw.academic.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "curso")
@JsonIgnoreProperties("turmas")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "tipoCurso")
    private String tipoCurso;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;

    @JsonBackReference
    @OneToMany(mappedBy = "curso")
    private List<MatrizCurricular> matrizCurricular;
}
