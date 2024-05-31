package com.company.lunna.dtos.requests;
import com.company.lunna.entitys.enderecoHospital.EnderecoHospital;

public record FichaMedRequestDTO (
        String planSaud,
        String cuidados,
        String numCartSus,
        String remedios,
        String comidasAlergicas,
        String descTratamento,
        Integer qtdHoraMed,
        Float qtdMed,
        EnderecoHospital endereco
){ }
