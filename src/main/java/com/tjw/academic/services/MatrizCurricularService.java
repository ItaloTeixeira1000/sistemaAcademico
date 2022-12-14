package com.tjw.academic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tjw.academic.models.MatrizCurricular;
import com.tjw.academic.repositories.MatrizCurricularRepository;

@Service
public class MatrizCurricularService {
    @Autowired
    MatrizCurricularRepository curriculumMatrixRepository;

    public List<MatrizCurricular> listAll() {
        List<MatrizCurricular> curriculumMatrices = curriculumMatrixRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        ;
        return curriculumMatrices;
    }

    public MatrizCurricular getById(Long id) throws Exception {
        return curriculumMatrixRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a matriz curricular com o id: " + id.toString() + "."));
    }

    public MatrizCurricular save(MatrizCurricular curriculumMatrix) throws Exception {
        return curriculumMatrixRepository.save(curriculumMatrix);
    }

    public MatrizCurricular update(MatrizCurricular updatedCurriculumMatr, Long id) throws Exception {
        return this.curriculumMatrixRepository.findById(id)
                .map(curriculumMatrixDB -> {
                    curriculumMatrixDB = updatedCurriculumMatr;
                    return curriculumMatrixRepository.save(curriculumMatrixDB);
                })
                .orElseThrow(() -> new Exception("Não foi possivel encontrar a matriz curricular com o id: " + id.toString() + "."));
    }

    public void delete(Long id) throws Exception {
        if (!curriculumMatrixRepository.existsById(id)) {
            throw new Exception("Não foi possivel encontrar a matriz curricular com o id: " + id.toString() + ".");
        }
        curriculumMatrixRepository.deleteById(id);
    }

}
