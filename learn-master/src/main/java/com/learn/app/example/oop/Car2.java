package com.learn.app.example.oop;

import java.util.Map;

public class Car2 {
    /** state or fields **/
    private int seats;
    private int fuelCapacity;
    private int doors;
    private Map<Integer,Boolean> doorState;
    private int speed;


    /**  Behavior start **/
    public void  accelerate(int speed) {

    }

    /**  Behavior start **/
    public void  accelerate(int speed, boolean cruiseOn) {

    }

    public void openDoor(int fuel) {

    }

    public void closeDoor(int fuel) {

    }

    public void lockCar() {

    }

    public int getSeats() {
        return seats;
    }

//    public void setSeats(int seats) {
//        this.seats = seats;
//    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Map<Integer, Boolean> getDoorState() {
        return doorState;
    }

//    public void setDoorState(Map<Integer, Boolean> doorState) {
//        this.doorState = doorState;
//    }

    public int getSpeed() {
        return speed;
    }

//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }

    /**  Behavior start **/

//    public static void main(String[] args) {
//        Car car = new Car();
//    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
