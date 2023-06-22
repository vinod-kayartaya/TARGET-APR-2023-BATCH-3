package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class KeyboardUtilDemo {
    public static void main(String[] args) {
        String name = KeyboardUtil.getString("What's your name? ");
        int age = KeyboardUtil.getInteger("How old are you? ");
        double height = KeyboardUtil.getDouble("How tall are you? ");
        String city = KeyboardUtil.getString("Where are you from? ");

        System.out.println("Please verify your details: ");
        System.out.printf("Name   : %s%n", name);
        System.out.printf("Age    : %d years%n", age);
        System.out.printf("City   : %s%n", city);
        System.out.printf("Height : %s%n", height);
    }
}
