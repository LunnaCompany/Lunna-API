package com.company.lunna.service;

import com.company.lunna.dtos.ResponsavelRequestDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.repository.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository responsavelRepository;

    public Responsavel saveResponsavel(ResponsavelRequestDTO body){
        Responsavel responsavel = new Responsavel();
        BeanUtils.copyProperties(body, responsavel);
        return this.responsavelRepository.save(responsavel);
    }

    public Responsavel getResponsavelById(Integer responsavelId) {
        return this.responsavelRepository.findById(responsavelId).orElseThrow(() -> new RuntimeException("responsavel nao encontrado"));
    }
}
