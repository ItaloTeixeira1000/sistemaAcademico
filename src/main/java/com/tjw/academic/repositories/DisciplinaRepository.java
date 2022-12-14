package com.tjw.academic.repositories;

import com.tjw.academic.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Query("SELECT d FROM Disciplina d WHERE d.nome = ?1")
    List<Disciplina> findByName(String name);

    @Query("SELECT d FROM Disciplina d WHERE d.nome = ?1 AND d.id <> ?2")
    List<Disciplina> findByNameId(String name, Long id);
}
