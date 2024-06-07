package com.company.lunna.controller;

import com.company.lunna.dtos.requests.LoginRespRequestDTO;
import com.company.lunna.dtos.responses.LoginResponseDTO;
import com.company.lunna.dtos.responses.ResponsavelResponseDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.responsavel.exception.ResponsavelNotFoundException;
import com.company.lunna.mappers.ResponsavelMapper;
import com.company.lunna.security.TokenService;
import com.company.lunna.service.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveResponsavel(@RequestParam String body,
                                                       @RequestParam("ftPerfilResp") MultipartFile ftPerfilResp,
                                                       @RequestParam("ftRgResp") MultipartFile ftRgResp) throws IOException {

        Responsavel responsavelSaved = this.responsavelService.saveResponsavel(body, ftPerfilResp, ftRgResp);
        String token = this.tokenService.generateToken(responsavelSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LoginResponseDTO(responsavelSaved.getNomeResp(), token));
    }

    @PostMapping("/login-responsavel")
    public ResponseEntity login(@RequestBody LoginRespRequestDTO body){
        Responsavel responsavel = responsavelService.getResponsavelByEmail(body.email());
        if (passwordEncoder.matches(body.senha(), responsavel.getSenha())){
            String token = tokenService.generateToken(responsavel);
            return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(responsavel.getNomeResp(), token));
        }

        return  ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelResponseDTO>> getAllResponsaveis(){
        List<Responsavel> responsaveis = this.responsavelService.getAllResponsaveis();
        List<ResponsavelResponseDTO> responsavelResponse = this.responsavelMapper.toResponsavelResponseList(responsaveis);
        return ResponseEntity.status(HttpStatus.OK).body(responsavelResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelResponseDTO> getResponsavel(@PathVariable Integer id) {
            Responsavel responsavel = this.responsavelService.getResponsavelById(id);
            ResponsavelResponseDTO responsavelResponse = this.responsavelMapper.toResponsavelResponseDTO(responsavel);
            return ResponseEntity.ok().body(responsavelResponse);
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
