package com.tjw.academic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "matriz_curricular")
public class MatrizCurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_vigencia")
    @Temporal(TemporalType.DATE)
    private Calendar dataVigencia;

    @ManyToMany
    private List<Disciplina> disciplinas;

    @ManyToOne
    private Curso curso;
}
