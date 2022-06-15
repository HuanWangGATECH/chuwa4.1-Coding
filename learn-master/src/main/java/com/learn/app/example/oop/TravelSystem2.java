package com.learn.app.example.oop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TravelSystem2 {
    // Dependency Injection
    private BeanFactory beanFactory;

    public TravelSystem2(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public static void main(String[] args) {
        // factory logic
        ApplicationContext context = new AnnotationConfigApplicationContext(TravelSystemConfig.class);
        Vehicle vehicle = context.getBean("MotorBike",Vehicle.class);
        vehicle.accelerate(5);


    }

}
