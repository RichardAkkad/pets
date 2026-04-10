package com.richy.pets.Configiration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfigiration {

    @Bean
    public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return  http.csrf(customize-> customize.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/homePage").permitAll().anyRequest().authenticated()).
                formLogin(Customizer.withDefaults()).build();



    }
}
