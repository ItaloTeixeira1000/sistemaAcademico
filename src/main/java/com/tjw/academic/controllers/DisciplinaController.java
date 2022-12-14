package com.tjw.academic.controllers;

import com.tjw.academic.models.Disciplina;
import com.tjw.academic.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina/")
public class DisciplinaController {
    @Autowired
    DisciplinaService disciplineService;

    @GetMapping
    List<Disciplina> listAll() {
        return disciplineService.listAll();
    }

    @GetMapping("{id}")
    Disciplina getById(@PathVariable Long id) throws Exception {
        return disciplineService.getById(id);
    }

    @PostMapping
    Disciplina save(@RequestBody Disciplina discipline) throws Exception {
        return disciplineService.save(discipline);
    }

    @PutMapping("{id}")
    Disciplina update(@RequestBody Disciplina discipline, @PathVariable Long id) throws Exception {
        return disciplineService.update(discipline, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        disciplineService.delete(id);
    }
}
