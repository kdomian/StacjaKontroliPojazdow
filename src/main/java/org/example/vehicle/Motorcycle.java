package org.example.vehicle;
/*
* Klasa Motorcycle dziedzicząca po klasie Vehicle zawierająca pola do opisu motocykla
* */
public class Motorcycle extends Vehicle {
    private final int numWheels;
    
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