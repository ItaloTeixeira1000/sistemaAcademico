package com.tjw.academic.controllers;

import com.tjw.academic.models.Curso;
import com.tjw.academic.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso/")
public class CursoController {
    @Autowired
    CursoService courseService;

    @GetMapping
    List<Curso> listAll() {
        return courseService.listAll();
    }

    @GetMapping("{id}")
    Curso getById(@PathVariable Long id) throws Exception {
        return courseService.getById(id);
    }

    @PostMapping
    Curso save(@RequestBody Curso course) throws Exception {
        return courseService.save(course);
    }

    @PutMapping("{id}")
    Curso update(@RequestBody Curso course, @PathVariable Long id) throws Exception {
        return courseService.update(course, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
