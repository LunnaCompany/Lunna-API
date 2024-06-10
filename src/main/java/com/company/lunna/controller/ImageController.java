package com.company.lunna.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/images")
public class ImageController {
    @GetMapping
    public ResponseEntity<Resource> getImage(@RequestParam String filename) {
        try {
            // Sanitize the path to ensure security
            Path sanitizedPath = Paths.get("src/main/resources/static/uploads").resolve(Paths.get(filename).getFileName().toString()).normalize();
            Resource resource = new UrlResource(sanitizedPath.toUri());

            if (resource.exists() || resource.isReadable()) {
                // Determine the content type based on the file extension
                String contentType = "application/octet-stream";
                if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
                    contentType = "image/jpeg";
                } else if (filename.endsWith(".png")) {
                    contentType = "image/png";
                } else if (filename.endsWith(".gif")) {
                    contentType = "image/gif";
                }

                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                throw new FileNotFoundException("Imagem não encontrada: " + filename);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Erro ao carregar imagem " + filename, ex);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
