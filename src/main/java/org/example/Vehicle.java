package org.example;

public class Vehicle {
    protected String brand;

    public Vehicle(String brand){
        this.brand=brand;
    }

    public void honk(){
        System.out.println("TuTuTu");
    }
}
