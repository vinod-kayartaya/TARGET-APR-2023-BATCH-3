package com.kvinod.programs;

import com.edgeverve.utils.KeyboardUtil;

import java.util.Date;

public class HelloWorld {
    public static void main(String[] args) {
        String name = KeyboardUtil.getString("Enter name: ");
        Date dob = KeyboardUtil.getDate("Enter birth date: ");

        System.out.printf("Hello, %s!%n", name);
        System.out.printf("Your date of birth is %s%n", dob);
    }
}
