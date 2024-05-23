package com.company.lunna.controller;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.service.DiscenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discente")
@RequiredArgsConstructor
public class DiscenteController {
    private final DiscenteService discenteService;
    @PostMapping
    public ResponseEntity<Discente> saveDiscente(@RequestBody DiscenteRequestDTO body){
        Discente discenteSaved = this.discenteService.saveDiscente(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(discenteSaved);
    }
}
