package com.tjw.academic.services;

import com.tjw.academic.exception.ResourceNotFoundException;
import com.tjw.academic.models.Professor;
import com.tjw.academic.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> listAll() {
        return professorRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Professor getById(Long id) {
        return professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Professor save(Professor professor) throws Exception {
        this.validateExistingProfessor(professor);
        return professorRepository.save(professor);
    }

    public Professor update(Professor updatedProfessor, Long id) throws Exception {
        this.validateExistingProfessor(updatedProfessor);
        return this.professorRepository.findById(id)
                .map(professor -> {
                    professor = updatedProfessor;
                    return professorRepository.save(professor);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        professorRepository.deleteById(id);
    }

    private void validateExistingProfessor(Professor professor) throws Exception {
        Long idProfessor = professor.getId();
        if (idProfessor != null) {
        	if (this.professorRepository.findByCpfAndId(professor.getCpf(), idProfessor).size() > 0) {
                throw new Exception("CPF já cadastrado.");
            }

            if (this.professorRepository.findByEmailAndId(professor.getEmail(), idProfessor).size() > 0) {
                throw new Exception("Email já cadastrado.");
            }

            if (this.professorRepository.findByRegisterAndId(professor.getRg(), idProfessor).size() > 0) {
                throw new Exception("RG já cadastrado.");
            }
        } else {
        	if (this.professorRepository.findByCpf(professor.getCpf()).size() > 0) {
                throw new Exception("CPF já cadastrado.");
            }

            if (this.professorRepository.findByEmail(professor.getEmail()).size() > 0) {
                throw new Exception("Email já cadastrado.");
            }

            if (this.professorRepository.findByRegister(professor.getRg()).size() > 0) {
                throw new Exception("RG já cadastrado.");
            }
        }
        
    }


}
