package com.richy.pets.Services;

import com.richy.pets.Model.Employee;
import com.richy.pets.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public  class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    EmployeeRepository employeeRepository;



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{


        Employee=employeeRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username not found"));
       
           return User.builder().username(Employee.get().getUsername()).password(Employee.get().getPassword()).roles(Employee.get().getRole().toString()).build();

        




    }











}
