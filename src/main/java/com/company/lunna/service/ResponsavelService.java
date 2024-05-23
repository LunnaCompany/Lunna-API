package com.company.lunna.service;

import com.company.lunna.dtos.ResponsavelRequestDTO;
import com.company.lunna.entitys.responsavel.Responsavel;
import com.company.lunna.entitys.responsavel.exception.ReponsavelCpfAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ReponsavelEmailAlreadyExistsException;
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
        verifyResponsavelExists(body.cpfResp(), body.emailResp());

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
    public void verifyResponsavelExists(String cpf, String email){
        if(this.responsavelRepository.findByEmailResp(email).isPresent()) {
            throw new ReponsavelEmailAlreadyExistsException("O email desse responsavel ja foi cadastrado");
        }

        if(this.responsavelRepository.findByCpfResp(cpf).isPresent()){
            throw new ReponsavelCpfAlreadyExistsException("O CPF desse responsavel ja foi cadastrado");
        }
    }

}
