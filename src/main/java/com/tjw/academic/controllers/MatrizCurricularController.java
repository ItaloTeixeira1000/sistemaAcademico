package com.tjw.academic.controllers;

import com.tjw.academic.models.MatrizCurricular;
import com.tjw.academic.services.MatrizCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriz-curricular/")
public class MatrizCurricularController {
    @Autowired
    MatrizCurricularService curriculumMatrixService;

    @GetMapping
    List<MatrizCurricular> listAll() {
        return curriculumMatrixService.listAll();
    }

    @GetMapping("{id}")
    MatrizCurricular getById(@PathVariable Long id) throws Exception {
        return curriculumMatrixService.getById(id);
    }

    @PostMapping
    MatrizCurricular save(@RequestBody MatrizCurricular curriculumMatrix) throws Exception {
        return curriculumMatrixService.save(curriculumMatrix);
    }

    @PutMapping("{id}")
    MatrizCurricular update(@RequestBody MatrizCurricular curriculumMatrix, @PathVariable Long id) throws Exception {
        return curriculumMatrixService.update(curriculumMatrix, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) throws Exception {
        curriculumMatrixService.delete(id);
    }
}
