package com.tjw.academic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tjw.academic.models.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    @Query("SELECT s FROM Estudante s WHERE s.matricula = ?1 AND s.id <> ?2")
    List<Estudante> findByRegisterId(String matricula, Long id);

    @Query("SELECT s FROM Estudante s WHERE s.matricula = ?1")
    List<Estudante> findByRegister(String matricula);
}
