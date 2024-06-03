package com.company.lunna.dtos.responses;


import com.company.lunna.dtos.requests.FichaMedRequestDTO;
import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.entitys.deficiencia.Deficiencia;
import com.company.lunna.entitys.fichaMed.FichaMed;
import com.company.lunna.entitys.momento.Momento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscenteResponseDTO {
    private Integer idDisc;
    private String cpfDisc;
    private String nomeDisc;
    private LocalDate dataNasDisc;
    private Float alturaDisc;
    private Float pesoDisc;
    private String imgDisc;
    private String defiencia;
    private FichaMedIdResponseDto idFichaMed;
    private ContatoEmergenciaResponseDTO idContato;
    private Momento idMomento;
    private List<ResponsavelIdResponseDTO> idResp;
}