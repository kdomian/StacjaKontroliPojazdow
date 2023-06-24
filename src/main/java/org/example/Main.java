package org.example;

import org.example.vehicle.Car;
import org.example.vehicle.Motorcycle;
import org.example.vehicle.Truck;
import org.example.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();

        Car car1 = new Car("Audi", "80", 1993, "SO2304E", 4);
        Motorcycle motorcycle1 = new Motorcycle("Yamaha", "YBR", 2007, "SK1234T", 2);
        Truck truck1 = new Truck("MAN", "T1000", 2022, "SD12340", 34);

        vehicleList.add(car1);
        vehicleList.add(motorcycle1);
        vehicleList.add(truck1);

        vehicleList.forEach(vehicle -> {
            System.out.println(vehicle.getDescription());});
    }

}