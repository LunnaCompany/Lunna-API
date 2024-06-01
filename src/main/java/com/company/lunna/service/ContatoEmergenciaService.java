package com.company.lunna.service;

import com.company.lunna.dtos.requests.ContatoEmergenciaRequestDTO;
import com.company.lunna.entitys.contatoEmergencia.ContatoEmergencia;
import com.company.lunna.repository.ContatoEmergenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoEmergenciaService {
    private final ContatoEmergenciaRepository contatoEmergenciaRepository;
    public ContatoEmergencia saveContatoEmergencia(ContatoEmergenciaRequestDTO body){
        ContatoEmergencia contatoEmergencia = new ContatoEmergencia();
        BeanUtils.copyProperties(body, contatoEmergencia);
        return this.contatoEmergenciaRepository.save(contatoEmergencia);
    }

    public List<ContatoEmergencia> getAllContatoEmergencia(){
        return this.contatoEmergenciaRepository.findAll();
    }
}
