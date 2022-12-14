package com.tjw.academic.controllers;

import com.tjw.academic.models.Turma;
import com.tjw.academic.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma/")
public class TurmaController {
    @Autowired
    TurmaService classService;

    @GetMapping
    List<Turma> listAll() {
        return classService.listAll();
    }

    @GetMapping("{id}")
    Turma getById(@PathVariable Long id) throws Exception {
        return classService.getById(id);
    }

    @PostMapping
    Turma save(@RequestBody Turma classParam) throws Exception {
        return classService.save(classParam);
    }

    @PutMapping("{id}")
    Turma update(@RequestBody Turma classParam, @PathVariable Long id) throws Exception {
        return classService.update(classParam, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) throws Exception {
        classService.delete(id);
    }
}
