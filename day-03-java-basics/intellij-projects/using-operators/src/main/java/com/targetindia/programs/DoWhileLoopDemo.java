package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class DoWhileLoopDemo {
    public static void main(String[] args) {
        int n1 = KeyboardUtil.getInteger("Enter number 1: ");
        int n2 = KeyboardUtil.getInteger("Enter number 2: ");

        int choice;

        do {
            System.out.println("Here are your choices: ");
            System.out.println("0. Exit");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Power");
            System.out.println("7. n1-th root of n2");
            System.out.println("8. Primes between");
            choice = KeyboardUtil.getInteger("Enter your choice: ");

            switch (choice) {
                case 0:
                    System.out.println("Thank you, have a nice day!");
                    break;
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
            }
        } while (choice != 0);
    }
}
