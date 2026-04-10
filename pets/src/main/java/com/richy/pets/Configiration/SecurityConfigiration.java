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
        //httpBasic(Customizer.withDefaults()).build();
        // login.loginPage("/myLoginPage") here is used to redirect to our own login page instead of the been sent to the generated login page(with /login) which is where it will send you automatically if we use loginForm method without using the loginPage method ,
        // With logoutUrl will send us to the login form if using a generated one (ie send us to /login) otherwise need to specify which url you want to use. (again not sure but i think need to use logOut method without logouturl method to be sent to generated login page
       //loginPage method is which endpoint to get verified from the login page, will make a custom loginPage page with Url /loginPage
        //loginProcessingUrl is which login form you want to intercept to get password and username from whether its the generated login form or your custom one. It automatically intercepts the generated login form if dont include this method( might need to include loginForm method for this to happen though)



    }
}
