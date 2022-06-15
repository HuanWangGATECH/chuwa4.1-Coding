package com.learn.app.example.oop;

/**
 * OOP, Singleton, simple factory and simple factory method
 */
public final class TravelSystem {

    private static TravelSystem travelByCar = new TravelSystem();

    public static TravelSystem getInstance() {
        return travelByCar;
    }

    private TravelSystem() {

    }

    public static void main(String[] args) throws Exception{
        try {


            Vehicle vehicle = CarFactory.getInstance().getVehicle("Car");
            vehicle.start();
            vehicle.accelerate(4);

            Car autoPilotCar = (Car)vehicle;

            autoPilotCar.accelerate(4, true);
            autoPilotCar.accelerate(4, true);
        } catch(Exception e) {
            CarFactory.getInstance().getVehicle("MotorBike");
        }

    }

}
