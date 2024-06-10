package com.company.lunna.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoEmergenciaResponseDTO {
    private String nome;
    private String numeroTelefone;
    private String numeroCelular;
    private String parentesco;
}
