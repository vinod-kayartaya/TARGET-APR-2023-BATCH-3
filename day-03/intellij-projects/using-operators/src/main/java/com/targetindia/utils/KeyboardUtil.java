package com.targetindia.utils;

import java.util.Scanner;

public class KeyboardUtil {
    // the following function is a pure function. Which means, it takes one or more arguments,
    // work on the arguments, and returns a value. This function does not have any dependency on the
    // internal state (member variables) of this class. In order to invoke such functions, we don't
    // need an object of this class to be created. So we generally mark such functions as 'static', so
    // that it can be invoked by using the classname
    public static String getString(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getInteger(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static double getDouble(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}
