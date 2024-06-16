package com.company.lunna.mappers;

import com.company.lunna.dtos.responses.DiscenteResponseDTO;
import com.company.lunna.dtos.responses.ResponsavelResponseDTO;
import com.company.lunna.dtos.responses.TurmaResponseDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.turma.Turma;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TurmaMapper {
    private final ModelMapper modelMapper;
    public List<TurmaResponseDTO> toTurmaResponseDTOList(List<Turma> turmas){
        return turmas.stream()
                .map(this::toTurmaResponseDTOList)
                .collect(Collectors.toList());
    }

    public TurmaResponseDTO toTurmaResponseDTOList(Turma turma){
        return modelMapper.map(turma, TurmaResponseDTO.class);
    }

}
