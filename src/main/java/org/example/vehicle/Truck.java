package org.example.vehicle;

public class Truck extends Vehicle {
    private double maxLoad;
    
    public Truck(String brand, String model, int year, String plateNumber, double maxLoad) {
        super(brand, model, year, plateNumber);
        this.maxLoad = maxLoad;
    }
    
    public double getMaxLoad() {
        return maxLoad;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", MAX LOAD:"+ maxLoad;
    }
}