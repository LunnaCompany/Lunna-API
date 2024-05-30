package com.company.lunna.service;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.dtos.ResponsavelRequestDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.responsavel.exception.ReponsavelCpfAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ReponsavelEmailAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ResponsavelNotFoundException;
import com.company.lunna.repository.ResponsavelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository responsavelRepository;
    private final FileStorageService fileStorageService;

    public Responsavel saveResponsavel(String body, MultipartFile ftPerfilResp, MultipartFile ftRgResp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        ResponsavelRequestDTO responsavelRequestDTO = objectMapper.readValue(body, ResponsavelRequestDTO.class);

        verifyResponsavelExists(responsavelRequestDTO.cpfResp(), responsavelRequestDTO.emailResp());

        String ftPerfilRespPath = this.fileStorageService.saveFile(ftPerfilResp);
        String ftRgRespPath  = this.fileStorageService.saveFile(ftRgResp);

        Responsavel responsavel = new Responsavel();
        BeanUtils.copyProperties(responsavelRequestDTO, responsavel);

        responsavel.setFtPerfilResp(ftPerfilRespPath);
        responsavel.setFtPerfilResp(ftRgRespPath);

        BeanUtils.copyProperties(body, responsavel);
        return this.responsavelRepository.save(responsavel);
    }

    public List<Responsavel> getAllResponsaveis(){
        return this.responsavelRepository.findAll();
    }

    public Responsavel getResponsavelById(Integer responsavelId) {
        return this.responsavelRepository.findById(responsavelId).orElseThrow(() -> new ResponsavelNotFoundException("responsavel não encontrado"));
    }
    public void verifyResponsavelExists(String cpf, String email){
        if(this.responsavelRepository.findByEmailResp(email).isPresent()) {
            throw new ReponsavelEmailAlreadyExistsException("O email desse responsavel ja foi cadastrado");
        }

        if(this.responsavelRepository.findByCpfResp(cpf).isPresent()){
            throw new ReponsavelCpfAlreadyExistsException("O CPF desse responsavel ja foi cadastrado");
        }
    }

}
