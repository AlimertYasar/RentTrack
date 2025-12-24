package com.example.renttrack;

import java.io.Serializable;

public class Car implements Serializable {
    public String name;
    public String plate;
    public String status;
    public String renter;
    public String duration;
    public String timeElapsed;
    public int imageResId;

    public Car(String name, String plate, String status, String renter, String duration, String timeElapsed, int imageResId) {
        this.name = name;
        this.plate = plate;
        this.status = status;
        this.renter = renter;
        this.duration = duration;
        this.timeElapsed = timeElapsed;
        this.imageResId = imageResId;
    }
}

