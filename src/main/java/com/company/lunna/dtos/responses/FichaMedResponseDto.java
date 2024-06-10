package com.company.lunna.dtos.responses;

import com.company.lunna.entitys.enderecoHospital.EnderecoHospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaMedResponseDto {
    private String planSaud;
    private String cuidados;
    private String numCartSus;
    private String remedios;
    private String comidasAlergicas;
    private String descTratamento;
    private Integer qtdHoraMed;
    private EnderecoHospital endereco;

}
