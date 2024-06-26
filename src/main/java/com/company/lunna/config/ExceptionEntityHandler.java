package com.company.lunna.config;

import com.company.lunna.entitys.discente.exception.DiscenteCpfAlreadyExistsException;
import com.company.lunna.entitys.discente.exception.DiscenteNotFoundException;
import com.company.lunna.entitys.fichaMed.exception.FichaMedNotFoundException;
import com.company.lunna.entitys.responsavel.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

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

    @ExceptionHandler(DiscenteNotFoundException.class)
    public ResponseEntity handlerDiscenteNotFound(DiscenteNotFoundException exception){
        String errorMessage = "O discente não foi encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(DiscenteCpfAlreadyExistsException.class)
    public ResponseEntity handlerDiscenteCpfAlreadyExists(DiscenteCpfAlreadyExistsException exception){
        String errorMessage = "O CPF dessa crianca ja esta em uso";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(FichaMedNotFoundException.class)
    public ResponseEntity handlerFichaMedNotFoundException(FichaMedNotFoundException exception){
        String errorMessage = "Ficha medica não encontrada";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }



}
