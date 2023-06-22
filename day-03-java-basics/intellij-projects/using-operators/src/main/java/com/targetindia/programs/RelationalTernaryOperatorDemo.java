package com.targetindia.programs;

import java.util.Scanner;

public class RelationalTernaryOperatorDemo {
    public static void main1(String[] args) {
        int n1;
        int n2;
        int largestN;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        System.out.printf("n1 = %d, and n2=%d%n", n1, n2);
        largestN = n1 > n2 ? n1 : n2;
        System.out.printf("largest of the inputs is %d%n", largestN);
    }

    public static void main(String[] args) {
        int n1;
        int n2;
        int largestN;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        System.out.printf("n1 = %d, and n2=%d%n", n1, n2);

        System.out.println(
                n1 == n2 ?
                        "both inputs are same" :
                        (n1 > n2 ?
                                n1 + " is the bigger value" :
                                n2 + " is the bigger value"));
    }
}
