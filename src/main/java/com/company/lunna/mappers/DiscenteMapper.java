package com.company.lunna.mappers;

import com.company.lunna.dtos.responses.DiscenteResponseDTO;
import com.company.lunna.dtos.responses.ResponsavelIdResponseDTO;
import com.company.lunna.entitys.discente.Discente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscenteMapper {

    public List<DiscenteResponseDTO> toDiscenteResponseList(List<Discente> discentes){
        return discentes.stream()
                .map(this::toDiscenteResponseDTO)
                .collect(Collectors.toList());
    }

    private DiscenteResponseDTO toDiscenteResponseDTO(Discente discente) {
        List<ResponsavelIdResponseDTO> responsaveisIds = discente.getResponsaveis().stream()
                .map(responsavel -> new ResponsavelIdResponseDTO(responsavel.getIdResp()))
                .collect(Collectors.toList());

        return new DiscenteResponseDTO(
                discente.getIdDisc(),
                discente.getCpfDisc(),
                discente.getNomeDisc(),
                discente.getDataNasDisc(),
                discente.getAlturaDisc(),
                discente.getPesoDisc(),
                discente.getImgDisc(),
                discente.getIdDef(),
                discente.getIdFichaMed(),
                discente.getIdContato(),
                discente.getIdMomento(),
                responsaveisIds
        );
    }
}