package com.learn.app.example.oop;

public class CarBuilderImpl implements CarBuilder {
    private int doors;
    private int fuelCapacity;


    @Override
    public CarBuilder setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    @Override
    public CarBuilder setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    @Override
    public Car2 build() {
        Car2 car = new Car2();
        car.setFuelCapacity(fuelCapacity);
        car.setDoors(doors);
        return car;
    }
}

