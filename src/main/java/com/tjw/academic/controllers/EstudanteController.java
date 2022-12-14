package com.tjw.academic.controllers;

import com.tjw.academic.models.Estudante;
import com.tjw.academic.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudante/")
public class EstudanteController {
    @Autowired
    EstudanteService studentService;

    @GetMapping
    List<Estudante> listAll() {
        return studentService.listAll();
    }

    @GetMapping("{id}")
    Estudante getById(@PathVariable Long id) throws Exception {
        return studentService.getById(id);
    }

    @PostMapping
    Estudante save(@RequestBody Estudante student) throws Exception {
        return studentService.save(student);
    }

    @PutMapping("{id}")
    Estudante update(@RequestBody Estudante student, @PathVariable Long id) throws Exception {
        return studentService.update(student, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
