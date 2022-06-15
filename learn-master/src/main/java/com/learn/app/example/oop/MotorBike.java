package com.learn.app.example.oop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MotorBike")
public class MotorBike extends MotorVehicle{
    @Override
    public String name() {
        System.out.println("MotorBike");
        return "MotorBike";
    }

    @Override
    public void start() {
        System.out.println("started....");
    }

    public void pressClutch() {
        System.out.println("clutch pressed");
    }

    public void releaseClutch() {
        System.out.println("clutch released");
    }

    @Override
    public void accelerate(int speed) {
        pressClutch();
        setSpeed(speed);
        releaseClutch();
    }

}
