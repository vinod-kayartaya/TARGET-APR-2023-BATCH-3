package com.targetindia.programs;

import java.util.Scanner;

public class ProblemWithScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int age;
        String city;

        System.out.printf("What is your name? ");
        name = sc.nextLine(); // reads one line from the keyboard
        System.out.printf("How old are you? ");
        age = sc.nextInt(); // read the next available int

        // solution for the problem.
        sc.nextLine(); // read the '\n' and ignore the same

        System.out.printf("Where are you from? ");
        city = sc.nextLine(); // read the next available characters until the '\n'

        System.out.println("Please verify your details: ");
        System.out.printf("Name : %s%n", name);
        System.out.printf("Age  : %d years%n", age);
        System.out.printf("City : %s%n", city);


    }
}
