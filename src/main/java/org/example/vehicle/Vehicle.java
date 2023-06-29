package org.example.vehicle;

import java.io.Serializable;
/*
* Klasa abstrakcyjna Vehicle zawierająca pola i metody wspólne dla wszystkich pojazdów
* */
public abstract class Vehicle implements Serializable {
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
    /*
    * Metoda abstrakcyjna getDescription() zwracająca opis pojazdu. W zależności od tego jaki pojazd zostanie utworzony
    * */
    public String getDescription(){
        return "VEHICLE TYPE:" + this.getClass().getSimpleName() + ", BRAND:" + brand + ", MODEL:" + model + ", YEAR:" + year + ", PLATE NUMBER:" + plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlateNumber(String newPlateNumber) {
        this.plateNumber = newPlateNumber;
    }
}