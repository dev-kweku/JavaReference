package org.example;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.reflect.*;
import javax.crypto.*;

import static org.example.Test.validateAge;


class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}

class BankAccount{
    private double balance;
    public double getBalance(){return balance;}

    public void deposit(double amt){balance += amt;}
}
//abstraction
abstract class Shape{
    abstract void draw();
    void info(){
        System.out.println("Shape class");
    }
}

class Circle extends Shape{
    void draw(){
        System.out.println("Drawing class");
    }
}

//polymorphism @method overloading

class MathUtils{
    int add(int a,int b){return a+b;}
    double add(double a,double b){return a+b;}
}
class Animals{
    void eat(){
        System.out.println("Animal eats");
    }
}

class Dogs extends Animals{
    void bark(){
        System.out.println("Dog barks");
    }

}
class Student{
    String name;
    int age;

    Student(){
        this.name="Unknown";
        this.age=0;
    }

    void studentDisplay(String name, int age){
        this.name=name;
        this.age=age;
        System.out.println("my name is " + this.name + " am " + this.age + " years old");
    }
}

class Cars{
    String brand;
    int speed;

    void drive(){
        System.out.println(brand + " is driving " + speed + " km/h");
    }

        }
interface Payment{
    void pay(double amount);
}

class RealPayment implements Payment{
    public void pay(double amount){
        System.out.println("processing payment of $" + amount);
    }
}
class PaymentProxy implements InvocationHandler{
final Object target;
public PaymentProxy(Object target){
    this.target=target;
}
public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
    System.out.println("Before method :" +method.getName());
    Object result=method.invoke(target,args);
    System.out.println("After method :" + method.getName());
    return result;
}
}
class Task implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(500);

            }catch(InterruptedException e){
                System.err.println("Thread interrupted");
            }
        }
    }
}
public class Main {
    public static void main(String[] args) throws Exception {

        try{
            validateAge(16);
        }catch(InvalidAgeException e){
            System.out.println("Caught :" + e.getMessage());
        }
//exceptions
        CheckErr();
//        encapsulation
        BankAccount account=new BankAccount();
        account.deposit(300);
        System.out.println("my bank acct balance is " +account.getBalance());

//        call abstract class
        Circle circle=new Circle();
        circle.draw();
        circle.info();

        Dogs myAnimals=new Dogs();
        myAnimals.eat();
        myAnimals.bark();

        Student student=new Student();
        student.age=25;
        student.name="Degraft Frimpong";
        student.studentDisplay(student.name, student.age);

//        call cars class to create object
        Cars myCar=new Cars();
        myCar.brand="Tesla";
        myCar.speed=150;
        myCar.drive();

        Payment realPayment=new RealPayment();
        Payment proxyPayment=(Payment) Proxy.newProxyInstance(
                Payment.class.getClassLoader(),
                new Class[]{Payment.class},
                new PaymentProxy(realPayment)
        );

        proxyPayment.pay(100.0);

//        Thread
        Thread t1=new Thread(new Task(),"Thread-1");
        Thread t2=new Thread(new Task(),"Thread-2");

        t1.start();
        t2.start();
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
        List();
        Main getSet=new Main();
        getSet.mySet();
        getSet.myMap();
        OptimizePerformance();

//        data cypher
//        Crypto();

    List<Integer> numbers=Arrays.asList(1,2,3,4,5);

    Runnable task=()-> System.out.println("Lambda task running");
    task.run();


//    stream
        List<Integer> squaredEven=numbers.stream().filter(n->n%2==0).map(n->n*n).toList();

        System.out.println("Squared Evens " + squaredEven);


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
    static void List(){
        List<String> students=new ArrayList<>();
        students.add("degraft");
        students.add("kweku");
        students.add("frimpong");
        students.add("degraft");
        System.out.println(students);

    }

//    Set
   void mySet(){
        Set<Integer> set=new HashSet<>();
        set.add(101);
        set.add(102);
        set.add(101);
       System.out.println(set);
   }
   void myMap(){
        Map<String,Double> grades=new HashMap<>();
        grades.put("Degraft",2.7);
        grades.put("Frimpong",3.7);
        grades.put("Kweku",3.8);
       System.out.println(grades);


   }

   public static void Crypto() throws Exception {
//        generate key
       KeyGenerator keyGen=KeyGenerator.getInstance("AES");
       keyGen.init(256);
       SecretKey secretKey=keyGen.generateKey();

//       encrypt data
       Cipher cipher=Cipher.getInstance("AES/GCM/NoPadding");
       cipher.init(Cipher.ENCRYPT_MODE,secretKey);
       byte[] encryptedData=cipher.doFinal("Sensitive Data".getBytes());

//       decrypt data
       cipher.init(Cipher.DECRYPT_MODE,secretKey);
       byte[] decryptedData=cipher.doFinal(encryptedData);

       System.out.println("decrypted :" + new String(decryptedData));
   }

   public static void OptimizePerformance(){
       ExecutorService executor= Executors.newFixedThreadPool(4);

       for(int i=0;i<10;i++){
           final int taskId=i;
           executor.submit(()->{
               System.out.println("Task " + taskId + " executed by " +Thread.currentThread().getName());
           });
       }
       executor.shutdown();
   }

   static void CheckErr(){
        try{
            int z=10/0;
        }catch(ArithmeticException e){
            System.out.println("Can't divide by zero :" + e);
        }finally {
            System.out.println("Finally always run");
        }
   }

//   checked exceptions
    static void Test(){
        try {
        FileReader fr=new FileReader("text.txt");
        }catch(IOException e){
            System.out.println("File not found");
        }

        }

}