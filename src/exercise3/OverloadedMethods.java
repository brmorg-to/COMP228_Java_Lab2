package exercise3;

public class OverloadedMethods {

    //Implementation of overloaded methods that print different parameters

    public static void displayInput(int num1, int num2){
        System.out.printf("Number 1: %d & Number2: %d%n", num1, num2);
    }

    public static void displayInput(String yourName, int age){
        System.out.printf("Hi, %s , so you are %d years old.\n", yourName, age);
    }

    public static void displayInput(double payRate, double numHours){
        System.out.printf("The employee has a pay rate of %.2f and worked %.2f hours.\n",payRate, numHours);
    }
}
