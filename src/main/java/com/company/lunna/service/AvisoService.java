package com.company.lunna.service;

import com.company.lunna.dtos.requests.AvisoRequestDTO;
import com.company.lunna.entitys.aviso.Aviso;
import com.company.lunna.repository.AvisoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvisoService {
    private final AvisoRepository avisoRepository;
    public Aviso saveAviso (AvisoRequestDTO body){
        Aviso aviso = new Aviso();
        BeanUtils.copyProperties(body, aviso);
        return this.avisoRepository.save(aviso);
    }

    public List<Aviso> getAllAviso(){
        return this.avisoRepository.findAll();
    }
}
