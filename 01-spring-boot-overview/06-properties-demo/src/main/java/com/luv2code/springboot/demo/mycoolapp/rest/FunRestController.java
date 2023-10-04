package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    @Value("${coach.name}")
    public String coach_name;
    @Value("${team.name}")
    public String team_name;

    // expose new endpoint for "team info"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " +coach_name + "Team Name: " + team_name ;
    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello world!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }
}
