package com.example.demo.Model;

import lombok.Data;

@Data
public class AbroadTrip extends Trip {

    private float insurance;

    public AbroadTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    @Override
    public float getPrice() {
        return super.getPrice() + insurance;
    }
}
