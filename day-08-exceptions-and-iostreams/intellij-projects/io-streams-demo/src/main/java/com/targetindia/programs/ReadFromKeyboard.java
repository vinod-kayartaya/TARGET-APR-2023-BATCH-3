package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {

    static void demo1() throws IOException {
        System.out.println("Enter your name: ");
        String name = "";

        int ch;

        while ((ch = System.in.read()) != '\n') {
            name += (char) ch;
        }

        System.out.printf("Hello, %s. How are you today?%n", name);
    }

    static void demo2() throws IOException {
        byte[] bytes = new byte[100];
        System.out.println("Enter your name: ");
        System.in.read(bytes);
        String name = new String(bytes).trim();

        System.out.printf("Hello, %s. How are you today?%n", name);
        System.out.printf("name.length() is %d%n", name.length());
    }

    static  void demo3() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        System.out.print("Enter your name: ");
        String name = in.readLine();
        System.out.print("Enter your city: ");
        String city = in.readLine();

        System.out.printf("Hello, %s. How's weather in %s?%n", name, city);
    }

    public static void main(String[] args) throws IOException {
        demo3();
    }
}
