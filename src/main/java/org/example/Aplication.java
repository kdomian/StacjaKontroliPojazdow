package org.example;

import org.example.vehicle.Car;
import org.example.vehicle.Motorcycle;
import org.example.vehicle.Truck;
import org.example.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplication {
    private final List<Vehicle> vehicleList;

    public Aplication() {
        vehicleList = new ArrayList<>();
    }

    //Wyświetlanie menu głównego
    public void viewMainMenu(){
        System.out.println("Menu");
        System.out.println("0. Wyszuakj pojazd po numerze rejestracyjnym");
        System.out.println("1. Pokaż listę pojazdów");
        System.out.println("2. Dodaj nowy pojazd");
        System.out.println("3. Edytuj pojazd");
        System.out.println("4. Usuń pojazd");
        System.out.println("5. Wyjście");
    }

    //Wyświetlanie menu edycji
    public void viewEditMenu(){
        System.out.println("Menu");
        System.out.println("1. Edytuj markę");
        System.out.println("2. Edytuj model");
        System.out.println("3. Edytuj rok produkcji");
        System.out.println("4. Edytuj numer rejestracyjny");
        System.out.println("5. Wyjście");
    }

    //Wyświetlanie listy pojazdów
    private Vehicle searchVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer rejestracyjny pojazdu");
        String plateNumber = scanner.nextLine();

        Vehicle vehicle = findVehicleByNumberPlate(plateNumber);

        if(vehicle != null){
            System.out.println(vehicle.getDescription());
            return vehicle;
        }else{
            System.out.println("Nie znaleziono pojazdu");
            return null;
        }
    }

    private Vehicle findVehicleByNumberPlate(String plateNumber) {
        Vehicle vehicle = null;
        for (Vehicle v : vehicleList) {
            if (v.getPlateNumber().equals(plateNumber)) {
                vehicle = v;
                break;
            }
        }
        return vehicle;
    }

    public void viewVehicleList(){
        System.out.println("Lista pojazdów");
        if(vehicleList.isEmpty()){
            System.out.println("Brak pojazdów");
        }else{
            for (int i = 0; i < vehicleList.size(); i++) {
                System.out.println(i + ". " + vehicleList.get(i).getDescription());
            }
        }
    }
    //Dodawanie nowego pojazdu

    public void addNewVehicle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dodawanie nowego pojazdu");
        System.out.println("Podaj markę pojazdu");
        String brand = scanner.nextLine();
        System.out.println("Podaj model pojazdu");
        String model = scanner.nextLine();
        System.out.println("Podaj rok produkcji pojazdu");
        int year = scanner.nextInt();
        scanner.nextLine(); //bez tej linijki program chciał pobrać numer rejestracyjny od razu po roku produkcji
        System.out.println("Podaj numer rejestracyjny pojazdu");
        String plateNumber = scanner.nextLine();
        //sprawdzanie czy numer rejestracyjny nie jest już zajęty
        Vehicle vehicle = findVehicleByNumberPlate(plateNumber);
        if(vehicle != null){
            System.out.println("Pojazd o podanym numerze rejestracyjnym już istnieje");
            return;
        }
        System.out.println("Podaj typ pojazdu");
        System.out.println("1. Samochód");
        System.out.println("2. Motocykl");
        System.out.println("3. Ciężarówka");
        int type = scanner.nextInt();
        switch (type){
            case 1:
                System.out.println("Podaj liczbę drzwi");
                int numDoors = scanner.nextInt();
                vehicleList.add(new Car(brand, model, year, plateNumber, numDoors));
                break;
            case 2:
                System.out.println("Podaj liczbę kół");
                int numWheels = scanner.nextInt();
                vehicleList.add(new Motorcycle(brand, model, year, plateNumber, numWheels));
                break;
            case 3:
                System.out.println("Podaj maksymalny ładunek");
                double maxLoad = scanner.nextDouble();
                vehicleList.add(new Truck(brand, model, year, plateNumber, maxLoad));
                break;
        }
    }

    //Edycja pojazdu
    public void editVehicle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edycja pojazdu");
        Vehicle vehicle = searchVehicle();
        if(vehicle != null){
            viewEditMenu();
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Podaj nową markę");
                    String brand = scanner.nextLine();
                    vehicle.setBrand(brand);
                    break;
                case 2:
                    System.out.println("Podaj nowy model");
                    String model = scanner.nextLine();
                    vehicle.setModel(model);
                    break;
                case 3:
                    System.out.println("Podaj nowy rok produkcji");
                    int year = scanner.nextInt();
                    vehicle.setYear(year);
                    break;
                case 4:
                    System.out.println("Podaj nowy numer rejestracyjny");
                    String newPlateNumber = scanner.nextLine();
                    vehicle.setPlateNumber(newPlateNumber);
                    break;
            }
        }
    }

    //Usuwanie pojazdu
    public void deleteVehicle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usuwanie pojazdu");
        Vehicle vehicle = searchVehicle();
        if(vehicle != null){
            vehicleList.remove(vehicle);
        }
    }

    //Metoda uruchamiająca aplikację
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            viewMainMenu();
            int option = scanner.nextInt();
            switch (option){
                case 0:
                    searchVehicle();
                    break;
                case 1:
                    viewVehicleList();
                    break;
                case 2:
                    addNewVehicle();
                    break;
                case 3:
                    editVehicle();
                    break;
                case 4:
                    deleteVehicle();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }

    public void addVehiclesToTest() {
        vehicleList.add(new Car("Ford", "Focus", 2010, "KR12345", 5));
        vehicleList.add(new Car("Opel", "Astra", 2015, "KR54321", 5));
        vehicleList.add(new Motorcycle("Yamaha", "R1", 2018, "KR67890", 2));
        vehicleList.add(new Motorcycle("Honda", "CBR", 2019, "KR09876", 2));
        vehicleList.add(new Truck("Scania", "R500", 2017, "KR13579", 20000));
        vehicleList.add(new Truck("Volvo", "FH16", 2016, "KR24680", 25000));
    }
}
