package com.company.lunna.dtos.requests;

import lombok.Data;


public record TurmaRequestDTO (
        String nomeTurma,
        Integer quantidadeAlunos,
        String periodo,
        String tema
){ }
