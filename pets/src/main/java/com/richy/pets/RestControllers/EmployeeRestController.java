package com.richy.pets.RestControllers;

import com.richy.pets.Model.Employee;
import com.richy.pets.Repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/searchEmployee")
    public ResponseEntity<Employee> searchEmployee() {
        Employee employee=null;
        Optional<Employee> optionalEmployee=employeeRepository.findById(1);
        if(optionalEmployee.isPresent()){
            ResponseEntity<Employee> employeeResponseEntity=ResponseEntity.ok().header("message","student found").body(optionalEmployee.get());
            return employeeResponseEntity;
        }

        return ResponseEntity.notFound().build();




    }
}
