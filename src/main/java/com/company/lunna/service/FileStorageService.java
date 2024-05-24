package com.company.lunna.service;

import com.company.lunna.dtos.DiscenteRequestDTO;
import com.company.lunna.entitys.discente.Discente;
import com.company.lunna.repository.DiscenteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class FileStorageService {
    public String saveFile(MultipartFile file) throws IOException{
        String directoryPath = "src/main/resources/static/uploads/";

        Files.createDirectories(Paths.get(directoryPath));

        String filePath = Paths.get(directoryPath, file.getOriginalFilename()).toString();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }
}
