package com.tjw.academic.repositories;

import com.tjw.academic.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT p FROM Professor p WHERE p.cpf = ?1 AND p.id <> ?2")
    List<Professor> findByCpfAndId(String cpf, Long id);

    @Query("SELECT p FROM Professor p WHERE p.email = ?1 AND p.id <> ?2")
    List<Professor> findByEmailAndId(String email, Long id);

    @Query("SELECT p FROM Professor p WHERE p.rg = ?1 AND p.id <> ?2 ")
    List<Professor> findByRegisterAndId(String rg, Long id);
    
    @Query("SELECT p FROM Professor p WHERE p.cpf = ?1")
    List<Professor> findByCpf(String cpf);

    @Query("SELECT p FROM Professor p WHERE p.email = ?1")
    List<Professor> findByEmail(String email);

    @Query("SELECT p FROM Professor p WHERE p.rg = ?1")
    List<Professor> findByRegister(String rg);
}
