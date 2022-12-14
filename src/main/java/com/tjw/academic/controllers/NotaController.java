package com.tjw.academic.controllers;

import com.tjw.academic.models.Nota;
import com.tjw.academic.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota/")
public class NotaController {
    @Autowired
    NotaService scoreService;

    @GetMapping
    List<Nota> listAll() {
        return scoreService.listAll();
    }

    @GetMapping("{id}")
    Nota getById(@PathVariable Long id) throws Exception {
        return scoreService.getById(id);
    }

    @PostMapping
    Nota save(@RequestBody Nota score) throws Exception {
        return scoreService.save(score);
    }

    @PutMapping("{id}")
    Nota update(@RequestBody Nota score, @PathVariable Long id) throws Exception {
        return scoreService.update(score, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        scoreService.delete(id);
    }
}
