package com.company.lunna.dtos.responses;


import com.company.lunna.dtos.requests.FichaMedRequestDTO;
import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.entitys.deficiencia.Deficiencia;
import com.company.lunna.entitys.fichaMed.FichaMed;
import com.company.lunna.entitys.momento.Momento;

import java.time.LocalDate;
import java.util.List;

public record DiscenteResponseDTO(Integer idDisc, String cpfDisc, String nomeDisc, LocalDate dataNasDisc, Float alturaDisc, Float pesoDisc, String imgDisc, Deficiencia idDef, FichaMed idFichaMed, ContatoEmergencia idContato, Momento idMomento, List<ResponsavelIdResponseDTO> idResp) {

}
