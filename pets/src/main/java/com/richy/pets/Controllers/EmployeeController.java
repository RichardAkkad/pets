package com.richy.pets.Controllers;


import com.richy.pets.Model.Employee;
import com.richy.pets.Repository.EmployeeRepository;
import com.richy.pets.Roles.roles;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class EmployeeController {

        @Autowired
        EmployeeRepository employeeRepository;
        @Autowired
        PasswordEncoder passwordEncoder;

        @GetMapping("/homePage")
        public String homePage(){
            return "homePage";
        }

        @GetMapping("/employeePage")
        public String showEmployeeForm(Model model){
                model.addAttribute("employee",new Employee());
                return "saveEmployeePage";

        }
        @PostMapping("/saveEmployeePage")
        public String saveEmployee(@ModelAttribute Employee employee){
                employee.setPassword(passwordEncoder.encode(employee.getPassword()));

                employeeRepository.save(employee);
                return "successfulPage";
        }


}
