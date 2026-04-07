package com.richy.pets.Rest;


import jdk.jfr.Threshold;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class PetsRestController {

    @GetMapping("/homepage")
    @ResponseBody
    public String homePage(){

        return "This is the homepage";
    }




}
