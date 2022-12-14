package com.tjw.academic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tjw.academic.models.Turma;
import com.tjw.academic.repositories.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository classRepository;

    public List<Turma> listAll() {
        List<Turma> result = classRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return result;
    }

    public Turma getById(Long id) throws Exception {
        return classRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a turma com o id: " + id.toString() + "."));
    }

    public Turma save(Turma classSave) throws Exception {
        return classRepository.save(classSave);
    }

    public Turma update(Turma updatedClass, Long id) throws Exception {
        return this.classRepository.findById(id)
                .map(classBd -> {
                    classBd = updatedClass;
                    return classRepository.save(classBd);
                })
                .orElseThrow(() -> new Exception("Não foi possivel encontrar a turma com o id: " + id.toString() + "."));
    }

    public void delete(Long id) throws Exception {
        if (!classRepository.existsById(id)) {
            throw new Exception("Não foi possivel encontrar a turma com o id: " + id.toString() + ".");
        }
        classRepository.deleteById(id);
    }
}
