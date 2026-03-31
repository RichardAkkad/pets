package com.richy.pets;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;
import java.util.function.Predicate;

@Configuration
@EnableWebSecurity//tells spring use this class for the security and not the generated one

public class Configirations {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
              return  http.csrf(customize-> customize.disable()).logout(logout->logout.
                        logoutSuccessHandler((request, response, authentication) -> {
                                try {
                                    if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Role_Employee"))) {
                                        response.sendRedirect("/employee");
                                    } else {
                                        response.sendRedirect("/home");
                                    }
                                }
                                catch(IOException e) {
                                    throw new RuntimeException(e);
                                }

                                })).authorizeHttpRequests(auth->auth.requestMatchers("/employeePage","/accounts")).build();//.logoutSuccessUrl()) this is used to redirect instead of the been sent to the logout page which is what is happening with logoutUrl(also note that can write anything here doesnt need to be /logout


        }




}
