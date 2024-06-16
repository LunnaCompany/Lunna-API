package com.company.lunna.dtos.requests;

import com.company.lunna.entitys.discente.Discente;
import lombok.Data;

import java.util.List;


public record TurmaRequestDTO (
        String nomeTurma,
        Integer quantidadeAlunos,
        String periodo,
        String tema,
        List<DiscenteRequestDTO> discentes
){ }
