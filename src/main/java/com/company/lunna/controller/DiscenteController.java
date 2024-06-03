package com.company.lunna.controller;

import com.company.lunna.dtos.responses.DiscenteResponseDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.mappers.DiscenteMapper;
import com.company.lunna.service.DiscenteService;

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
@RequestMapping("/discente")
@RequiredArgsConstructor
public class DiscenteController {
    private final DiscenteService discenteService;
    private final DiscenteMapper discenteMapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Discente> saveDiscente(@RequestParam("body") String body,
                                                 @RequestParam("imgDisc") MultipartFile imgDisc,
                                                 @RequestParam("cpfResp") String cpfResp) throws IOException {

        Discente discenteSaved = this.discenteService.saveDiscente(body, imgDisc, cpfResp);
        return ResponseEntity.status(HttpStatus.CREATED).body(discenteSaved);
    }


    @GetMapping
    public ResponseEntity<List<DiscenteResponseDTO>> getAllDiscente(){
        List<Discente> discentes = discenteService.getAllDiscente();
        List<DiscenteResponseDTO> discenteResponse =  discenteMapper.toDiscenteResponseList(discentes);
        return ResponseEntity.status(HttpStatus.OK).body(discenteResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscenteResponseDTO> getDiscenteById(@PathVariable Integer id){
        Discente discente = this.discenteService.getDiscenteById(id);
        DiscenteResponseDTO discenteResponse = discenteMapper.toDiscenteResponseDTO(discente);
        return ResponseEntity.status(HttpStatus.OK).body(discenteResponse);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<DiscenteResponseDTO> getDiscenteByCpf(@PathVariable String cpf){
        Discente discente = this.discenteService.getDiscenteByCpf(cpf);
        DiscenteResponseDTO discenteResponse = this.discenteMapper.toDiscenteResponseDTO(discente);
        return ResponseEntity.status(HttpStatus.OK).body(discenteResponse);
    }


}
