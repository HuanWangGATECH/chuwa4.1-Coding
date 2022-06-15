package com.learn.app.data;

import org.springframework.stereotype.Component;


public class Address {
    private String street = "defaultAddress";


    public Address() {

    }
    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
