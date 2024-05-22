package com.company.lunna.controller;

import com.company.lunna.dtos.ResponsavelRequestDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.service.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/responsavel")
@RequiredArgsConstructor
public class ResponsavelController {
    private final ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsavel> saveResponsavel(@RequestBody ResponsavelRequestDTO body){
        Responsavel responsavelSaved = this.responsavelService.saveResponsavel(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> getResponsavel(@PathVariable Integer id){
        Responsavel responsavel = this.responsavelService.getResponsavelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responsavel);
    }
}
