package org.example;

public class Dog extends Animal implements Drivable{
    void makeSound(){
        System.out.println("Woof");
    }

    public void drive(){
        System.out.println("Dog can't drive!");
    }
}
