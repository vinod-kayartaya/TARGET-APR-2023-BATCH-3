package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class SelectionDemo {

    public static void main(String[] args) {
        int n1 = KeyboardUtil.getInteger("Enter number 1: ");
        int n2 = KeyboardUtil.getInteger("Enter number 2: ");

        System.out.println("Here are your choices: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");
        System.out.println("6. Power");
        System.out.println("7. n1-th root of n2");
        System.out.println("8. Primes between");
        int choice = KeyboardUtil.getInteger("Enter your choice: ");

        switch (choice) {
            case 1:
                System.out.printf("%d + %d = %d%n", n1, n2, n1 + n2);
                break;
            case 2:
                System.out.printf("%d - %d = %d%n", n1, n2, n1 - n2);
                break;
            case 3:
                System.out.printf("%d * %d = %d%n", n1, n2, n1 * n2);
                break;
            case 4:
                System.out.printf("%d / %d = %d%n", n1, n2, n1 / n2);
                break;
            case 5:
                System.out.printf("%d %% %d = %d%n", n1, n2, n1 % n2);
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Logic not implemented yet.");
                break;
            default:
                System.out.printf("Invalid choice %d. Please try again.%n", choice);
        } // break inside the switch-case brings the control here
    }

    public static void main2(String[] args) {
        int month = KeyboardUtil.getInteger("Enter month: ");
        int year = KeyboardUtil.getInteger("Enter year: ");

        boolean isOkay = true;

        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Must be between 1 and 12");
            isOkay = false;
        }

        if (year < 0) {
            System.out.println("Invalid year. Must be >=0");
            isOkay = false;
        }

        if (isOkay) {
            // the number of days in a month can be 28, 29, 30 or 31
            int days;
            if (month == 2) {
                if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
                    days = 29;
                } else {
                    days = 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 30;
            } else {
                days = 31;
            }

            System.out.printf("%d/%d has %d days%n", month, year, days);
        }

    }

    public static void main1(String[] args) {
        int year = KeyboardUtil.getInteger("Enter a number representing year: ");

        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            System.out.printf("The year %d is a leap year and has 366 days%n", year);
        } else {
            System.out.printf("The year %d is not a leap year and has 365 days%n", year);
        }
    }
}
