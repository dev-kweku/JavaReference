package org.example;

public class Test{
    static void validateAge(int age) throws InvalidAgeException {
        if(age < 18) throw new InvalidAgeException("Not eligible to vote");
        else System.out.println("User Eligible");
        
    }
}
