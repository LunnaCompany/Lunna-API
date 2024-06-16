package com.company.lunna.service;

import com.company.lunna.dtos.requests.TurmaRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.discente.exception.DiscenteNotFoundException;
import com.company.lunna.entitys.turma.Turma;
import com.company.lunna.repository.DiscenteRepository;
import com.company.lunna.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final DiscenteRepository discenteRepository; // Adicione essa linha

    public Turma saveTurma(TurmaRequestDTO body) {
        Turma turma = new Turma();
        turma.setNomeTurma(body.nomeTurma());
        turma.setQuantidadeAlunos(body.quantidadeAlunos());
        turma.setPeriodo(body.periodo());
        turma.setTema(body.tema());

        // Converte DiscenteRequestDTO para Discente e associa à Turma
        List<Discente> discentes = body.discentes().stream()
                .map(discenteDTO -> {
                    Discente discente = discenteRepository.findBycpfDisc(discenteDTO.cpfDisc())
                            .orElseThrow(() -> new DiscenteNotFoundException("Discente não encontrado: " + discenteDTO.cpfDisc()));
                    discente.setTurma(turma);
                    return discente;
                })
                .collect(Collectors.toList());

        turma.setDiscentes(discentes);

        return turmaRepository.save(turma);
    }


    public List<Turma> getTurmas(){
        return turmaRepository.findAll();
    }

}
