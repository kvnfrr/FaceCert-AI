package com.facecert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/static/**", "/models/**", "/css/**", "/js/**").permitAll() // Allow static resources
                        .requestMatchers("/", "/create-face-id", "/signin-face-id").permitAll() // Allow public pages
                        .anyRequest().authenticated() // Secure other endpoints
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Updated syntax
                );
        return http.build();
    }
}