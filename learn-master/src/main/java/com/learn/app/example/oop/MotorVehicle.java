package com.learn.app.example.oop;

public abstract class MotorVehicle implements Vehicle{
    /** state or fields **/
    private int seats;
    private int fuel;
    private int speed;

    public void ride() {
        System.out.println("riding on called by ::" +name());
    }

    public void lockCar() {
        System.out.println("locked on called by ::" +name());
    }

    public void setSpeed(int speed) {
        System.out.println("setSpeed called by ::" +name());
        this.speed = speed;
    }

}
