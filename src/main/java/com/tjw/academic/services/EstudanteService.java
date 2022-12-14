package com.tjw.academic.services;

import com.tjw.academic.exception.ResourceNotFoundException;
import com.tjw.academic.models.Estudante;
import com.tjw.academic.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {
    @Autowired
    EstudanteRepository studentRepository;

    public List<Estudante> listAll() {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Estudante getById(Long id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar o curso com o id: " + id.toString() + "."));
    }

    public Estudante save(Estudante student) throws Exception {
        this.validateExistingStudent(student);
        return studentRepository.save(student);
    }

    public Estudante update(Estudante updatedStudent, Long id) throws Exception {
        this.validateExistingStudent(updatedStudent);
        return this.studentRepository.findById(id)
                .map(studentDB -> {
                    studentDB = updatedStudent;
                    return studentRepository.save(studentDB);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }

    private void validateExistingStudent(Estudante student) throws Exception {
        Long id = student.getId();

        if(id != null && this.studentRepository.findByRegisterId(student.getMatricula(), id).size() > 0){
            throw new Exception("Aluno com esta matricula já foi cadastrado.");
        } else if (this.studentRepository.findByRegister(student.getMatricula()).size() > 0 && id == null){
            throw new Exception("Aluno com esta matricula já foi cadastrado.");
        }
    }
}
