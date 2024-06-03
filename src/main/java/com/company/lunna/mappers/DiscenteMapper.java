package com.company.lunna.mappers;

import com.company.lunna.dtos.responses.ContatoEmergenciaResponseDTO;
import com.company.lunna.dtos.responses.DiscenteResponseDTO;
import com.company.lunna.dtos.responses.FichaMedIdResponseDto;
import com.company.lunna.dtos.responses.ResponsavelIdResponseDTO;
import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.fichaMed.FichaMed;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DiscenteMapper {
    private final ModelMapper modelMapper;

    public List<DiscenteResponseDTO> toDiscenteResponseList(List<Discente> discentes){
        return discentes.stream()
                .map(this::toDiscenteResponseDTO)
                .collect(Collectors.toList());
    }



    private FichaMedIdResponseDto toFichaMedIdResponseDto(FichaMed fichaMed){
        if (fichaMed == null) {
            return null;
        }
        return modelMapper.map(fichaMed, FichaMedIdResponseDto.class);
    }

    private ContatoEmergenciaResponseDTO toContatoEmergenciaResponseDTO(ContatoEmergencia contatoEmergencia){
        if (contatoEmergencia == null) {
            return null;
        }
        return modelMapper.map(contatoEmergencia, ContatoEmergenciaResponseDTO.class);
    }


    public DiscenteResponseDTO toDiscenteResponseDTO(Discente discente) {
        List<ResponsavelIdResponseDTO> responsaveisIds = discente.getResponsaveis().stream()
                .map(responsavel -> new ResponsavelIdResponseDTO(responsavel.getIdResp()))
                .collect(Collectors.toList());

        FichaMedIdResponseDto fichaMedId = toFichaMedIdResponseDto(discente.getIdFichaMed());
        ContatoEmergenciaResponseDTO contatoId = toContatoEmergenciaResponseDTO(discente.getIdContato());

        return new DiscenteResponseDTO(
                discente.getIdDisc(),
                discente.getCpfDisc(),
                discente.getNomeDisc(),
                discente.getDataNasDisc(),
                discente.getAlturaDisc(),
                discente.getPesoDisc(),
                discente.getImgDisc(),
                discente.getDeficiencia(),
                fichaMedId,
                contatoId,
                discente.getIdMomento(),
                responsaveisIds
        );
    }
}