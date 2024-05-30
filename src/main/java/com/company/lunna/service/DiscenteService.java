package com.company.lunna.service;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.dtos.ResponsavelRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.discente.exception.DiscenteCpfAlreadyExistsException;
import com.company.lunna.entitys.discente.exception.DiscenteNotFoundException;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.repository.DiscenteRepository;
import com.company.lunna.repository.ResponsavelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscenteService {
    private final DiscenteRepository discenteRepository;
    private final ResponsavelRepository responsavelRepository;
    private final FileStorageService fileStorageService;

    public Discente saveDiscente(String body, MultipartFile imgDisc, String cpfResp) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        DiscenteRequestDTO discenteRequestDTO = objectMapper.readValue(body, DiscenteRequestDTO.class);


        verifyDiscenteExists(discenteRequestDTO.cpfDisc());

        String perfilImagePath = this.fileStorageService.saveFile(imgDisc);

        Responsavel responsavel = this.responsavelRepository.findByCpfResp(cpfResp).orElseThrow(() -> new RuntimeException("responsvel nao existe"));

        Discente discente = new Discente();
        BeanUtils.copyProperties(discenteRequestDTO, discente);

        if (discente.getResponsaveis() == null) {
            discente.setResponsaveis(new ArrayList<>());
        }

        discente.getResponsaveis().add(responsavel);
        responsavel.getDiscentes().add(discente);
        discente.setImgDisc(perfilImagePath);

        return this.discenteRepository.save(discente);
    }

    public List<Discente> getAllDiscente(){
        return this.discenteRepository.findAll();
    }

    public Discente getDiscenteById(Integer idDiscente){
        return this.discenteRepository.findById(idDiscente).orElseThrow(() -> new DiscenteNotFoundException("Discente não encontrado"));
    }

    private void verifyDiscenteExists(String cpf){
        if (this.discenteRepository.findBycpfDisc(cpf).isPresent()) {
            throw new DiscenteCpfAlreadyExistsException("O cpf do discente ja esta cadastrado");
        }
    }
}
