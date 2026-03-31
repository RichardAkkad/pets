package com.richy.pets.Rest;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class PetsRestController {

    @GetMapping("/homePage")
    public String homePage(){

        return "This is the Homepage";
    }




}
