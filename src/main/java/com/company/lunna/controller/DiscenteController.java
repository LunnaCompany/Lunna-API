package com.company.lunna.controller;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.service.DiscenteService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/discente")
@RequiredArgsConstructor
public class DiscenteController {
    private final DiscenteService discenteService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Discente> saveDiscente(@RequestParam("body") String body,
                                                 @RequestParam("imgDisc") MultipartFile imgDisc) throws IOException {

        Discente discenteSaved = this.discenteService.saveDiscente(body, imgDisc);
        return ResponseEntity.status(HttpStatus.CREATED).body(discenteSaved);
    }

}
