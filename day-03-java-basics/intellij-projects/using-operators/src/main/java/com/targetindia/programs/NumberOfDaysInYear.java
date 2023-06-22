package com.targetindia.programs;

import java.util.Scanner;

public class NumberOfDaysInYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a number representing an year: ");
        int year = scanner.nextInt();

        int days = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ? 366 : 365;
        System.out.printf("Number of days in the given year %d equals to %d%n", year, days);
    }
}
