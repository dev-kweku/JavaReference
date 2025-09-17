package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

public class Main {
    public static void main(String[] args) {
//        variables and data types
        int studentCount=150;
        double averageGrade=85.6;
        char gradez='A';
        boolean isPassing=true;

//        operators
        int total=studentCount+50;
        boolean isExcellent=(averageGrade > 90) && isPassing;
        System.out.println("Is Excellent? " + isExcellent);
        System.out.println("Total Student :" + total);

//        array
        int[] grades={88,92,76,95,89};

        int sum=0;
        for(int i =0;i<grades.length;i++){
            sum += grades[i];
        }
        double average=(double) sum/grades.length;
        if(average >=60){
            System.out.println("Pass Average: " + average);
        }else {
            System.out.println("Fail Average: " + average);
        }
        System.out.print("Grades: ");
        for (int grade:grades){
            System.out.println(grade + " ");

        }

//        creating inheritance method
        Car mycar=new Car("Toyota","Corolla");
        mycar.honk();
        mycar.display();

//        creating method for dog class
        Dog mydog=new Dog();
        mydog.makeSound();
        mydog.sleep();
        mydog.drive();
        checkException();
        GetFile();
        ReadFile();
    }

    public static void checkException(){
        try{
            int result=10/0;

        }catch(ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            System.out.println("Cleanup complete");
        }
    }
//    get file
    static void GetFile(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("output.txt"))){
            writer.write("Hello File in Java!");
        }catch (IOException e){
            System.err.println("File Error {Unable to create file} :"+ e.getMessage());
        }
    }

    static void ReadFile(){
        try(BufferedReader reader=new BufferedReader(new FileReader("output.txt"))){
            String line=reader.readLine();
            System.out.println("File content :" + line);
        }catch(IOException e){
            System.err.println("File Error :{Unable to read file}" + e.getMessage());
        }
    }
}