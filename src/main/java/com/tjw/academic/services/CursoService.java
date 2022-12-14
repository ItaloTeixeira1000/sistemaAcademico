package com.tjw.academic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tjw.academic.exception.ResourceNotFoundException;
import com.tjw.academic.models.Curso;
import com.tjw.academic.repositories.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository courseRepository;

    public List<Curso> listAll() {
        List<Curso> courses = courseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return courses;
    }

    public Curso getById(Long id) throws Exception {
        return courseRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar o curso com o id: " + id.toString() + "."));
    }

    public Curso save(Curso course) throws Exception {
        return courseRepository.save(course);
    }

    public Curso update(Curso updatedCourse, Long id) throws Exception {
        return this.courseRepository.findById(id)
                .map(courseDB -> {
                    courseDB = updatedCourse;
                    return courseRepository.save(courseDB);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }
}
