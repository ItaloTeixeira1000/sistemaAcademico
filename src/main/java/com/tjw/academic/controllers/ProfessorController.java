package com.tjw.academic.controllers;

import com.tjw.academic.models.Professor;
import com.tjw.academic.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor/")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @GetMapping
    List<Professor> listAll() {
        return professorService.listAll();
    }

    @GetMapping("{id}")
    Professor getById(@PathVariable Long id) {
        return professorService.getById(id);
    }

    @PostMapping
    Professor save(@RequestBody Professor professor) throws Exception {
        return professorService.save(professor);
    }

    @PutMapping("{id}")
    Professor update(@RequestBody Professor professor, @PathVariable Long id) throws Exception {
        return professorService.update(professor, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id){
        professorService.delete(id);
    }
}
