package org.example;

import org.example.vehicle.Car;
import org.example.vehicle.Motorcycle;
import org.example.vehicle.Truck;
import org.example.vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Klasa Aplication zawierająca główną logikę programu
public class Aplication {
    private final List<Vehicle> vehicleList;

    public Aplication() {
        vehicleList = readVehiclesFromFile();
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
    //Wyszukiwanie pojazdu po numerze rejestracyjnym
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

    //Wyświetlanie listy pojazdów
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
            scanner.nextLine(); //bez tej linijki program chciał pobrać numer rejestracyjny od razu po roku produkcji
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
                    if(findVehicleByNumberPlate(newPlateNumber) != null){
                        System.out.println("Pojazd o podanym numerze rejestracyjnym już istnieje");
                        return;
                    }
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
                    saveVehiclesToFile();
                    break;
            }
        }
    }

    //zapis listy pojazdów do pliku
    public void saveVehiclesToFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("vehicles.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vehicleList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //metoda zwracająca odczytane z pliku pojazdy, a jeżeli plik nie istnieje to tworzy nowy dokument
    public List<Vehicle> readVehiclesFromFile() {
        File file = new File("vehicles.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            List<Vehicle> vehicles = new ArrayList<>();
            try {
                FileInputStream fileInputStream = new FileInputStream("vehicles.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                vehicles = (List<Vehicle>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return vehicles;
        }
        return new ArrayList<>();
    }

}
