package com.company.lunna.config;

import com.company.lunna.dtos.responses.FichaMedIdResponseDto;
import com.company.lunna.entitys.fichaMed.FichaMed;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();

    }
}
