package com.tjw.academic.services;

import com.tjw.academic.exception.ResourceNotFoundException;
import com.tjw.academic.models.Nota;
import com.tjw.academic.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {
    @Autowired
    NotaRepository scoreRepository;

    public List<Nota> listAll() {
        return scoreRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Nota getById(Long id) throws Exception {
        return scoreRepository.findById(id).orElseThrow(() -> new Exception("Não foi possivel encontrar a pontuação com o id: " + id.toString() + "."));
    }

    public Nota save(Nota score) throws Exception {
        return scoreRepository.save(score);
    }

    public Nota update(Nota updatedScore, Long id) throws Exception {
        return this.scoreRepository.findById(id)
                .map(scoreDB -> {
                    scoreDB = updatedScore;
                    return scoreRepository.save(scoreDB);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        if (!scoreRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        scoreRepository.deleteById(id);
    }
}
