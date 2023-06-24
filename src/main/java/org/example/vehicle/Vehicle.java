package org.example.vehicle;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private String plateNumber;
    
    public Vehicle(String brand, String model, int year, String plateNumber) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
    public String getDescription(){
        return "VEHICLE TYPE:" + this.getClass().getSimpleName() + ", BRAND:" + brand + ", MODEL:" + model + ", YEAR:" + year + ", PLATE NUMBER:" + plateNumber;
    }
}