package com.company.lunna.service;

import com.company.lunna.dtos.requests.TurmaRequestDTO;
import com.company.lunna.entitys.turma.Turma;
import com.company.lunna.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public Turma saveTurma(TurmaRequestDTO body){
        Turma turma = new Turma();
        BeanUtils.copyProperties(body, turma);
        return turmaRepository.save(turma);
    }

    public List<Turma> getTurmas(){
        return turmaRepository.findAll();
    }

}
