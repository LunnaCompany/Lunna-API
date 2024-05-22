package com.company.lunna.dtos;

import com.company.lunna.entitys.endereco.Endereco;

public record ResponsavelRequestDTO(String nomeResp, String emailResp, String senha, String estadoCivilResp, String profissaoResp, Endereco enderecoResp) { }
