package com.company.lunna.controller;

import com.company.lunna.dtos.requests.TurmaRequestDTO;
import com.company.lunna.dtos.responses.ResponsavelResponseDTO;
import com.company.lunna.dtos.responses.TurmaResponseDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.turma.Turma;
import com.company.lunna.mappers.TurmaMapper;
import com.company.lunna.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/turma")
@RequiredArgsConstructor
public class TurmaController {
    private final TurmaService turmaService;
    private final TurmaMapper turmaMapper;

    @PostMapping
    public ResponseEntity<Turma> saveTurma(@RequestBody TurmaRequestDTO body){
        Turma turmaSaved = this.turmaService.saveTurma(body);
        return ResponseEntity.status(HttpStatus.OK).body(turmaSaved);
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> getAllTurma(){
        List<Turma> turmas = this.turmaService.getTurmas();
        List<TurmaResponseDTO> turmaResponse = this.turmaMapper.toTurmaResponseDTOList(turmas);
        return ResponseEntity.status(HttpStatus.OK).body(turmaResponse);
    }

}
