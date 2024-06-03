package com.company.lunna.controller;

import com.company.lunna.security.AuthenticateService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticateService authenticateService;

    @PostMapping("authenticate")
    public String authenticate(){
        return authenticateService.authenticate();
    }

}
