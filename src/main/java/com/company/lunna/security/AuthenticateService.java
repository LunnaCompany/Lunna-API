package com.company.lunna.security;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
    public String authenticate(){
        return "token";
    }
}
