package com.targetindia.programs;

import static java.lang.Math.*;
import static java.lang.System.out;
public class FunctionDemo {

    // non-static function
    void hello(){
        out.println("Hello, world!");
    }

    // static method
    static void welcome(){
        out.println("Welcome to Java learning!");
    }

    public static void main(String[] args) {

        // main() being a static method, can only call welcome() and not hello()
        welcome(); // this is assumed to be a function in this same class
        FunctionDemo.welcome();

        // hello(); // error
        FunctionDemo fd = new FunctionDemo();
        fd.hello();

        // calling a static method in Math.java
        out.printf("square root of %f is %.100f%n", 1234., sqrt(1234));
        out.printf("45 degree in radians is %f%n", toRadians(45));
    }
}
