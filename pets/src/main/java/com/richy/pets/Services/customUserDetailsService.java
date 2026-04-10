package com.richy.pets.Services;

import com.richy.pets.Model.Employee;
import com.richy.pets.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public  class customUserDetailsService implements UserDetailsService {


    @Autowired
    EmployeeRepository dogRepository;



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Optional<Employee> optionalEmployee=dogRepository.findByUsername(username);
        if(optionalEmployee.isPresent()){
           return User.builder().username(optionalEmployee.get().getUsername()).password(optionalEmployee.get().getPassword()).roles(optionalEmployee.get().getRole().toString()).build();

        }
       // else if(optionalEmployee.isPresent() &&  ){

        //}
        else{
            throw new UsernameNotFoundException("username not found");
        }

        //what we are trying to do is get the details from the database using the username here and return a UserDetails object



    }











}
