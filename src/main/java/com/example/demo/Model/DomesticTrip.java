package com.example.demo.Model;

import lombok.Data;

@Data
public class DomesticTrip extends Trip {

    private float ownArrivalDiscount;

    public DomesticTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
    }

    public void setOwnArrivalDiscount(float ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public float getPrice() {
        return super.getPrice() - ownArrivalDiscount;
    }
}
