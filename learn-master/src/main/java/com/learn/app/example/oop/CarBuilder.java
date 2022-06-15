package com.learn.app.example.oop;

public interface CarBuilder {
    CarBuilder setDoors(int doors);

    CarBuilder setFuelCapacity(int fuelCapacity);

    Car2 build();
}
