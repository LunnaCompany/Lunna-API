package com.company.lunna.dtos.requests;


public record ContatoEmergenciaRequestDTO(
        String nome,
        String numeroTelefone,
        String numeroCelular,
        String parentesco
) {
}
