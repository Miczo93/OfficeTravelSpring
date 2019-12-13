package com.example.demo.Model;

import lombok.Data;

@Data
public class Customer {
    private String name;
    private Address address;
    private Trip trip;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }


    public Trip getTrip() {
        return trip;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", trip=" + trip +
                '}';
    }
}
