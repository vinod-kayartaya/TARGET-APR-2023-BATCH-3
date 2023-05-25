package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class ScannerDemo {
    public static void main(String[] args) {
        String name;
        int age;
        double height;
        String city;

        name = KeyboardUtil.getString("Enter name: ");
        age =KeyboardUtil.getInt("Enter age: ");
        height = KeyboardUtil.getDouble("Enter height: ");
        city=KeyboardUtil.getString("Enter city: ");

        out.printf("Name   = %s%n", name);
        out.printf("Age    = %d years%n", age);
        out.printf("Height = %s%n", height);
        out.printf("City   = %s%n", city);
    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner provides many functions to read data from the input stream
        // next*
        // next(), nextInt(), nextDouble(), nextShort(), nextLong(), nextLine(), ...
        String name;
        int age;
        double height;
        String city;

        out.print("Enter name: ");
        name = sc.nextLine();
        out.print("Enter age: ");
        age = sc.nextInt();
        sc = new Scanner(System.in); // re-initialize the Scanner (fresh and new memory to collect input)
        out.print("Enter height: ");
        height = sc.nextDouble();
        sc = new Scanner(System.in); // re-initialize the Scanner (fresh and new memory to collect input)
        out.print("Enter city: ");
        city=sc.nextLine();

        out.printf("Name   = %s%n", name);
        out.printf("Age    = %d years%n", age);
        out.printf("Height = %s%n", height);
        out.printf("City   = %s%n", city);
    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner provides many functions to read data from the input stream
        // next*
        // next(), nextInt(), nextDouble(), nextShort(), nextLong(), nextLine(), ...
        String name;
        int age;
        double height;
        String city;

        out.print("Enter name: ");
        name = sc.nextLine();
        out.print("Enter age: ");
        age = sc.nextInt();
        sc.nextLine(); // skip the '\n' after the int
        out.print("Enter height: ");
        height = sc.nextDouble();
        sc.nextLine(); // skip the '\n' after the double
        out.print("Enter city: ");
        city=sc.nextLine();

        out.printf("Name   = %s%n", name);
        out.printf("Age    = %d years%n", age);
        out.printf("Height = %s%n", height);
        out.printf("City   = %s%n", city);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner provides many functions to read data from the input stream
        // next*
        // next(), nextInt(), nextDouble(), nextShort(), nextLong(), nextLine(), ...
        String name;
        int age;
        double height;
        String city;

        out.print("enter name, age, height and city separated with a space: ");
        name = sc.next();
        age = sc.nextInt();
        height = sc.nextDouble();
        city=sc.next();

        out.printf("Name   = %s%n", name);
        out.printf("Age    = %d years%n", age);
        out.printf("Height = %s%n", height);
        out.printf("City   = %s%n", city);
    }

    public static void main1(String[] args) throws IOException {
        out.print("Enter some text: ");
        int ch;
        String text = "";
        while ((ch = in.read()) != '\n') {
            text += (char) ch;
        }
        out.printf("You entered '%s'%n", text);

        out.println();
    }
}
