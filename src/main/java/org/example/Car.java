package org.example;

public class Car extends Vehicle{
    private String modelName;
    public Car(String brand,String modelName) {
        super(brand);
        this.modelName=modelName;
    }

    public void honk(){
        System.out.println("Beep beep");
    }

    public void display(){
        System.out.println("Car : " +brand + " " +modelName);
    }
}
