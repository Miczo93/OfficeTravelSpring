package com.example.demo.Model;

import lombok.Data;

@Data
public class Trip {
    private MyDate start, end;
    private String destination;
    private float price;

    public Trip() {
    }

    public Trip(MyDate start, MyDate end, String destination) {
        this.start = start;
        this.end = end;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}


