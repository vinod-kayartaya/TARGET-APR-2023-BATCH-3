package com.targetindia.programs;

import java.util.Scanner;

public class ScannerSolution {
    public static void main(String[] args) {
        Scanner sc;

        String name;
        int age;
        String city;

        System.out.printf("What is your name? ");
        sc = new Scanner(System.in);
        name = sc.nextLine(); // reads one line from the keyboard

        System.out.printf("How old are you? ");
        sc = new Scanner(System.in); // this is a new object; and the keyboard buffere is brand new
        age = sc.nextInt(); // read the next available int

        System.out.printf("Where are you from? ");
        sc = new Scanner(System.in); // this is a new object; and the keyboard buffere is brand new
        city = sc.nextLine(); // read the next available characters until the '\n'

        System.out.println("Please verify your details: ");
        System.out.printf("Name : %s%n", name);
        System.out.printf("Age  : %d years%n", age);
        System.out.printf("City : %s%n", city);
    }
}
