package org.example.vehicle;

public class Motorcycle extends Vehicle {
    private int numWheels;
    
    public Motorcycle(String brand, String model, int year, String plateNumber, int numWheels) {
        super(brand, model, year, plateNumber);
        this.numWheels = numWheels;
    }
    
    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", WHEELS NUMBER:"+ numWheels;
    }
}