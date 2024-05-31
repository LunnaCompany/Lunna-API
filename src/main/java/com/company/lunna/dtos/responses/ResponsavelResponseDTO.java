package com.company.lunna.dtos.responses;

import com.company.lunna.entitys.contato.Contato;
import com.company.lunna.entitys.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelResponseDTO {
    private Integer idResp;
    private String nomeResp;
    private String cpfResp;
    private String rgResp;
    private String emailResp;
    private String emailRecResp;
    private String profissaoResp;
    private String estadoCivilResp;
    private String ftRgResp;
    private String ftPerfilResp;
    private Contato contato;
    private Endereco enderecoResp;
    private List<DiscenteResponseDTO> discentes;
}
