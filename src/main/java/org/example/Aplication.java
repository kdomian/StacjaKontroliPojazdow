package org.example;

import java.util.Scanner;

public class Aplication {
    public void viewMenu(){
        System.out.println("Menu");
        System.out.println("Motocykl");
        System.out.println("Samochód");
        System.out.println("Ciężarówka");

    }
    public Integer getUserChoice(String info){
        System.out.println(info);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
