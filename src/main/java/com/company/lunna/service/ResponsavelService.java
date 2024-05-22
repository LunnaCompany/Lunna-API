package com.company.lunna.service;

import com.company.lunna.dtos.ResponsavelRequestDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.responsavel.exception.ReponsavelAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ResponsavelNotFoundException;
import com.company.lunna.repository.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository responsavelRepository;

    public Responsavel saveResponsavel(ResponsavelRequestDTO body){
        verifyResponsavelSubscription(body.emailResp());
        Responsavel responsavel = new Responsavel();
        BeanUtils.copyProperties(body, responsavel);
        return this.responsavelRepository.save(responsavel);
    }

    public List<Responsavel> getAllResponsaveis(){
        return this.responsavelRepository.findAll();
    }

    public Responsavel getResponsavelById(Integer responsavelId) {
        return this.responsavelRepository.findById(responsavelId).orElseThrow(() -> new ResponsavelNotFoundException("responsavel não encontrado"));
    }

    public void verifyResponsavelSubscription(String email){
        Optional<Responsavel> isResponsavelRegistered = this.responsavelRepository.findByEmailResp(email);
        if(isResponsavelRegistered.isPresent()) throw new ReponsavelAlreadyExistsException("Esse responsavel ja foi cadastrado");
    }
}
