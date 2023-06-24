package org.example.vehicle;

import org.example.vehicle.Vehicle;

public class Car extends Vehicle {
    private int numDoors;
    
    public Car(String brand, String model, int year, String plateNumber, int numDoors) {
        super(brand, model, year, plateNumber);
        this.numDoors = numDoors;
    }
    
    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", DOORS NUMBER:"+ numDoors;
    }
}