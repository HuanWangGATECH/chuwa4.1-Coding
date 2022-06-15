package com.learn.app.example.oop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Qualifier("Car")
public class Car extends MotorVehicle {
    private int doors;
    private Map<Integer,Boolean> doorState;
    private boolean autoPilot;

    /**  Behavior start **/
    public String name() {
        System.out.println("Car");
        return "Car";
    }

    public void start() {
        System.out.println("riding in car");
    }


    public void  accelerate(int speed, boolean cruiseOn) {
        accelerate(speed);
        this.autoPilot = true;
    }

    @Override
    public void accelerate(int speed) {
        setSpeed(speed);
    }
}
