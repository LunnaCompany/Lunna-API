package com.company.lunna.service;

import com.company.lunna.dtos.FichaMedRequestDTO;
import com.company.lunna.entitys.fichaMed.FichaMed;
import com.company.lunna.entitys.fichaMed.exception.FichaMedNotFoundException;
import com.company.lunna.repository.FichaMedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FichaMedService {
    private final FichaMedRepository fichaMedRepository;


    public FichaMed saveFichaMed(FichaMedRequestDTO body){
        FichaMed fichaMed = new FichaMed();
        BeanUtils.copyProperties(body, fichaMed);
        return this.fichaMedRepository.save(fichaMed);
    }

    public List<FichaMed> getAllfichaMed(){
        return this.fichaMedRepository.findAll();
    }

    public FichaMed getFichaMedById(Integer id){
        return this.fichaMedRepository.findById(id).orElseThrow(() -> new FichaMedNotFoundException("Ficha medica não encontrada"));
    }


}
