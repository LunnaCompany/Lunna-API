package com.company.lunna.dtos;

import com.company.lunna.entitys.contato.Contato;
import com.company.lunna.entitys.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public record ResponsavelRequestDTO(String nomeResp, String cpfResp, String rgResp, String emailResp, String emailRecResp, String senha, String profissaoResp, String estadoCivilResp, String ftRgResp, String ftPerfilResp, Contato contato, Endereco enderecoResp) {

}
