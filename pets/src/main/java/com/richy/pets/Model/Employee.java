package com.richy.pets.Model;


import com.richy.pets.Roles.roles;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int age;
    String firstName;
    String surname;
    String sex;
    LocalDate dateOfArrival;

    @Column(unique = true)
    String username;
    String password;

    roles role;



}


