package com.company.lunna.dtos.responses;


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
    private String deficiencia;
    private FichaMedResponseDto fichaMed;
    private ContatoEmergenciaResponseDTO contato;
    private Momento idMomento;
    private List<ResponsavelIdResponseDTO> idResp;
}