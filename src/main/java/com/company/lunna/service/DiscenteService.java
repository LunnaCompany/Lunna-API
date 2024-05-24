package com.company.lunna.service;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.entitys.discente.exception.DiscenteCpfAlreadyExistsException;
import com.company.lunna.repository.DiscenteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DiscenteService {
    private final DiscenteRepository discenteRepository;
    private final FileStorageService fileStorageService;

    public Discente saveDiscente(String body, MultipartFile imgDisc) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        DiscenteRequestDTO discenteRequestDTO = objectMapper.readValue(body, DiscenteRequestDTO.class);

        verifyDiscenteExists(discenteRequestDTO.cpfDisc());

        String perfilImagePath = this.fileStorageService.saveFile(imgDisc);

        Discente discente = new Discente();
        BeanUtils.copyProperties(discenteRequestDTO, discente);

        discente.setImgDisc(perfilImagePath);

        return this.discenteRepository.save(discente);
    }

    private void verifyDiscenteExists(String cpf){
        if (this.discenteRepository.findByCpf(cpf).isPresent()) {
            throw new DiscenteCpfAlreadyExistsException("O cpf do discente ja esta cadastrado");
        }
    }
}
