package com.company.lunna.controller;

import com.company.lunna.dtos.requests.AvisoRequestDTO;
import com.company.lunna.entitys.aviso.Aviso;
import com.company.lunna.service.AvisoService;
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
@RequiredArgsConstructor
@RequestMapping("/aviso")
public class AvisoController {
    private final AvisoService avisoService;
    @PostMapping
    public ResponseEntity<Aviso> saveAviso(@RequestBody AvisoRequestDTO body){
        Aviso avisoSaved = this.avisoService.saveAviso(body);
        return ResponseEntity.status(HttpStatus.OK).body(avisoSaved);
    }

    @GetMapping
    public ResponseEntity<List<Aviso>> getAllAviso(){
        return ResponseEntity.status(HttpStatus.OK).body(this.avisoService.getAllAviso());
    }
}
