package com.company.lunna.service;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.repository.DiscenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscenteService {
    private final DiscenteRepository discenteRepository;

    public Discente saveDiscente(DiscenteRequestDTO body){
        Discente discente = new Discente();
        BeanUtils.copyProperties(body, discente);
        return this.discenteRepository.save(discente);
    }

}
