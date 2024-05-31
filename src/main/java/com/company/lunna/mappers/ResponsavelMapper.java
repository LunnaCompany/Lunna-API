package com.company.lunna.mappers;

import com.company.lunna.dtos.responses.ResponsavelResponseDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ResponsavelMapper {
    private final ModelMapper modelMapper;

    public List<ResponsavelResponseDTO> toResponsavelResponseList(List<Responsavel> responsaveis){
        return responsaveis.stream()
                .map(this::toResponsavelResponseDTO)
                .collect(Collectors.toList());
    }

    public ResponsavelResponseDTO toResponsavelResponseDTO(Responsavel responsavel){
        return modelMapper.map(responsavel, ResponsavelResponseDTO.class);
    }

}
