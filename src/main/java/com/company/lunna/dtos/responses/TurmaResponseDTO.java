package com.company.lunna.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResponseDTO {
    private Integer idTurma;
    private String nomeTurma;
    private Integer quantidadeAlunos;
    private String periodo;
    private String tema;
    private List<DiscenteResponseDTO> discentes;
}
