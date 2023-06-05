package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class KeyboardUtil {
    public static double getDouble(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static int getInt(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getString(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Date getDate(String message)  {
        System.out.printf("%s(dd/mm/yyyy format) ", message);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(input);
        } catch (ParseException e) {
            System.out.println("Date was not in the requested format. Using null instead.");
            return null;
        }
    }
}
