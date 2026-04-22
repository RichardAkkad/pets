package com.richy.pets.Configiration;


import com.richy.pets.Filters.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;


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
    return  http.csrf(customize-> customize.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/homePage","/employeePage","/saveEmployeePage")
          .authenticated()).oauth2Login(Customizer.withDefaults()).formLogin(Customizer.withDefaults()).build();

            //httpBasic(Customizer.withDefaults()).build();addFilterBefore(new CustomFilter(), AuthorizationFilter.class).build();


            //formLogin(Customizer.withDefaults()).build();//addFilterBefore(new CustomFilter(), AuthorizationFilter.class).build();




    }
}
