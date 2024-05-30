package com.company.lunna.dtos.requests;

import com.company.lunna.entitys.endereco.Endereco;

public record FichaMedRequestDTO (String planSaud, String tipSang, String observacoes, String numCartSus, Double nConvenio, Endereco endereco, String remedios){
}
