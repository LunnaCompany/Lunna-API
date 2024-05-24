package com.company.lunna.config;

import com.company.lunna.entitys.discente.exception.DiscenteCpfAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ReponsavelCpfAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ReponsavelEmailAlreadyExistsException;
import com.company.lunna.entitys.responsavel.exception.ResponsavelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(ResponsavelNotFoundException.class)
    public ResponseEntity handlerResponsavelNotFound(ResponsavelNotFoundException exception){
        String errorMessage = "O responsavel não foi encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(ReponsavelEmailAlreadyExistsException.class)
    public ResponseEntity handlerEmailResponsavelAlreadyExists(ReponsavelEmailAlreadyExistsException exception){
        String errorMensagem = "O email desse responsavel ja esta em uso";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMensagem);
    }

    @ExceptionHandler(ReponsavelCpfAlreadyExistsException.class)
    public ResponseEntity handlerCpfResponsavelAlreadyExists(ReponsavelCpfAlreadyExistsException exception){
        String errorMessage = "O CPF desse responsavel ja esta em uso";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(DiscenteCpfAlreadyExistsException.class)
    public ResponseEntity handlerDiscenteCpfAlreadyExists(DiscenteCpfAlreadyExistsException exception){
        String errorMessage = "O CPF dessa crianca ja esta em uso";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
}
