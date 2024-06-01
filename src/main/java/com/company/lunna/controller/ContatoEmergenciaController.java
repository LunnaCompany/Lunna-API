package com.company.lunna.controller;

import com.company.lunna.dtos.requests.ContatoEmergenciaRequestDTO;
import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.service.ContatoEmergenciaService;
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
@RequestMapping("/contato-emergencia")
@RequiredArgsConstructor
public class ContatoEmergenciaController {
    private final ContatoEmergenciaService contatoEmergenciaService;

    @PostMapping
    public ResponseEntity<ContatoEmergencia> saveContatoEmergencia(@RequestBody ContatoEmergenciaRequestDTO body){
        ContatoEmergencia contatoEmergenciaSaved = this.contatoEmergenciaService.saveContatoEmergencia(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoEmergenciaSaved);
    }

    @GetMapping
    public ResponseEntity<List<ContatoEmergencia>> getAllContatoEmergencia(){
        return ResponseEntity.status(HttpStatus.OK).body(this.contatoEmergenciaService.getAllContatoEmergencia());
    }
}
