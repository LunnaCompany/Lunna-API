package com.company.lunna.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/responsavel").permitAll()
                        .requestMatchers(HttpMethod.POST, "/discente").permitAll()
                        .requestMatchers(HttpMethod.POST, "/ficha-med").permitAll()
                        .requestMatchers(HttpMethod.POST, "/contato-emergencia").permitAll()
                        .requestMatchers(HttpMethod.POST, "responsavel/login-responsavel").permitAll()
                        .requestMatchers(HttpMethod.POST, "/turma").permitAll()
                        .requestMatchers(HttpMethod.POST, "/aviso").permitAll()
                        .requestMatchers(HttpMethod.GET, "/responsavel/cpf/{cpf}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/responsavel/email/{email}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/discente/cpf/{cpf}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/responsavel").permitAll()
                        .requestMatchers(HttpMethod.GET, "/responsavel/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/images").permitAll()
                        .requestMatchers(HttpMethod.GET, "/contato-emergencia").permitAll()
                        .requestMatchers(HttpMethod.GET, "/discente").permitAll()
                        .requestMatchers(HttpMethod.GET, "/turma").permitAll()
                        .requestMatchers(HttpMethod.GET, "/aviso").permitAll()
                        .requestMatchers("/ws/**").permitAll()
                        .requestMatchers("/app/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}