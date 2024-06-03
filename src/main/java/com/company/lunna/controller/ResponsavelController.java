package com.company.lunna.controller;

import com.company.lunna.dtos.responses.ResponsavelResponseDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.mappers.ResponsavelMapper;
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
    private final ResponsavelMapper responsavelMapper;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Responsavel> saveResponsavel(@RequestParam String body,
                                                       @RequestParam("ftPerfilResp") MultipartFile ftPerfilResp,
                                                       @RequestParam("ftRgResp") MultipartFile ftRgResp) throws IOException {

        Responsavel responsavelSaved = this.responsavelService.saveResponsavel(body, ftPerfilResp, ftRgResp);
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelSaved);
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelResponseDTO>> getAllResponsaveis(){
        List<Responsavel> responsaveis = this.responsavelService.getAllResponsaveis();
        List<ResponsavelResponseDTO> responsavelResponse = this.responsavelMapper.toResponsavelResponseList(responsaveis);
        return ResponseEntity.status(HttpStatus.OK).body(responsavelResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelResponseDTO> getResponsavel(@PathVariable Integer id){
        Responsavel responsavel = this.responsavelService.getResponsavelById(id);
        ResponsavelResponseDTO responsavelResponse = this.responsavelMapper.toResponsavelResponseDTO(responsavel);
        return ResponseEntity.status(HttpStatus.OK).body(responsavelResponse);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponsavelResponseDTO> getResponsavelByEmail(@PathVariable String email){
        Responsavel responsavel = this.responsavelService.getResponsavelByEmail(email);
        ResponsavelResponseDTO responsavelResponseDTO = this.responsavelMapper.toResponsavelResponseDTO(responsavel);
        return ResponseEntity.status(HttpStatus.OK).body(responsavelResponseDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ResponsavelResponseDTO> getResponsavelByCPF(@PathVariable String cpf){
        Responsavel responsavel = this.responsavelService.getResponsavelByCpf(cpf);
        ResponsavelResponseDTO responsavelResponse = this.responsavelMapper.toResponsavelResponseDTO(responsavel);
        return ResponseEntity.status(HttpStatus.OK).body(responsavelResponse);
    }
}
