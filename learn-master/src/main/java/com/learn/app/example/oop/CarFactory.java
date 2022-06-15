package com.learn.app.example.oop;

public final class  CarFactory {

    private final static CarFactory carFactory = new CarFactory();

    private CarFactory() {

    }

    public static CarFactory getInstance() {
        return carFactory;
    }

    public  MotorVehicle getVehicle(String name) throws Exception {
        if("MotorBike".equals(name)) return new MotorBike();

        if("Car".equals(name)) {
            return new Car();
        }

        throw new Exception("vehicle not found");
    }

}
