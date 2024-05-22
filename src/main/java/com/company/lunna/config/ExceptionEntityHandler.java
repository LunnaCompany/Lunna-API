package com.company.lunna.config;

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

}
