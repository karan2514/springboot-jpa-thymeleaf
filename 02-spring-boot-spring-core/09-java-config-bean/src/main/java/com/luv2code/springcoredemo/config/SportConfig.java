package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.Coach;
import com.luv2code.springcoredemo.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
