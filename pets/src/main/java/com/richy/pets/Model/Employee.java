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
    int Id;

    String firstName;
    String surname;
    int Age;
    String Sex;
    @Column(unique = true)
    String username;
    String Password;

    roles role;

    LocalDate DateOfArrival;


}


