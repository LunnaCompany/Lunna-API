package com.company.lunna.controller;

import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.service.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/responsavel")
@RequiredArgsConstructor
public class ResponsavelController {
    private final ResponsavelService responsavelService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Responsavel> saveResponsavel(@RequestParam String body,
                                                       @RequestParam("ftPerfilResp") MultipartFile ftPerfilResp,
                                                       @RequestParam("ftRgResp") MultipartFile ftRgResp) throws IOException {
        Responsavel responsavelSaved = this.responsavelService.saveResponsavel(body, ftPerfilResp, ftRgResp);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelSaved);
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> getAllResponsaveis(){
        return ResponseEntity.status(HttpStatus.OK).body(this.responsavelService.getAllResponsaveis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> getResponsavel(@PathVariable Integer id){
        Responsavel responsavel = this.responsavelService.getResponsavelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responsavel);
    }
}
