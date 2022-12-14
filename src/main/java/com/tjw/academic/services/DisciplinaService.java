package com.tjw.academic.services;

import com.tjw.academic.exception.ResourceNotFoundException;
import com.tjw.academic.models.Disciplina;
import com.tjw.academic.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplineRepository;

    public List<Disciplina> listAll() {
        return disciplineRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Disciplina getById(Long id) throws Exception {
        return disciplineRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a disciplina com o id: " + id.toString() + "."));
    }

    public Disciplina save(Disciplina discipline) throws Exception {
        this.validateExistingDiscipline(discipline);
        return disciplineRepository.save(discipline);
    }

    public Disciplina update(Disciplina disciplineUpdated, Long id) throws Exception {
        this.validateExistingDiscipline(disciplineUpdated);
        return this.disciplineRepository.findById(id)
                .map(disciplineDB -> {
                    disciplineDB = disciplineUpdated;
                    return disciplineRepository.save(disciplineDB);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (!disciplineRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        disciplineRepository.deleteById(id);
    }

    private void validateExistingDiscipline(Disciplina discipline) throws Exception {
        Long idDiscipline = discipline.getId();

        if (idDiscipline != null && this.disciplineRepository.findByNameId(discipline.getNome(), idDiscipline).size() > 0) {
            throw new Exception("Disciplina já cadastrada.");
        } else if (this.disciplineRepository.findByName(discipline.getNome()).size() > 0 && idDiscipline == null){
            throw new Exception("Disciplina já cadastrada.");
        }
    }
}
