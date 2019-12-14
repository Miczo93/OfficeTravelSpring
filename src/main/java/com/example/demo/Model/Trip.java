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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public MyDate getStart() {
        return start;
    }

    public void setStart(MyDate start) {
        this.start = start;
    }

    public MyDate getEnd() {
        return end;
    }

    public void setEnd(MyDate end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
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


