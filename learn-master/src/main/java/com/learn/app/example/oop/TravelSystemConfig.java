package com.learn.app.example.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravelSystemConfig {

    @Bean("Car")
    public Vehicle car() {
        return new Car();
    }

    @Bean("MotorBike")
    public Vehicle motorBike() {
        return new MotorBike();
    }
}
