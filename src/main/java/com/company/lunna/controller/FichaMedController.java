package com.company.lunna.controller;

import com.company.lunna.dtos.FichaMedRequestDTO;
import com.company.lunna.entitys.fichaMed.FichaMed;
import com.company.lunna.repository.FichaMedRepository;
import com.company.lunna.service.FichaMedService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ficha-med")
@AllArgsConstructor
public class FichaMedController {
    private FichaMedService fichaMedService;
    @PostMapping
    public ResponseEntity<FichaMed> saveFichaMed (@RequestBody FichaMedRequestDTO body){
        FichaMed fichaMedSaved = this.fichaMedService.saveFichaMed(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaMedSaved);
    }

    @GetMapping
    public ResponseEntity<List<FichaMed>> getAllFichaMed (){
        return ResponseEntity.status(HttpStatus.OK).body(fichaMedService.getAllfichaMed());
    }

    @GetMapping("{id}")
    public ResponseEntity<FichaMed> getFicha(@RequestParam Integer id){
        FichaMed fichaMed = this.fichaMedService.getFichaMedById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fichaMed);
    }
}
