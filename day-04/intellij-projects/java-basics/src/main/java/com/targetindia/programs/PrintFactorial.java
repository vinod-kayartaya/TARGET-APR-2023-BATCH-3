package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class PrintFactorial {

    static void printFactorials() {
        int start = KeyboardUtil.getInt("Enter the first number: ");
        int end = KeyboardUtil.getInt("Enter the second number: ");

        if (start < 0) {
            throw new RuntimeException("First number must be >= 0");
        }
        if (start >= end) {
            throw new RuntimeException("First number must < second number!");
        }

        for (int num = start; num <= end; num++) {
            System.out.printf("factorial of %d is %d%n", num, factorial(num));
        }
    }

    static long factorial(int num) {

        if (num < 0) {
            throw new RuntimeException("Cannot calculate factorial of " + num);
        }

        long f = 1;

        for (int i = 1; i <= num; i++) {
            f *= i;
        }

        return f;
    }

    public static void main(String[] args) {
        printFactorials();
    }

    public static void main1(String[] args) {
        int n = KeyboardUtil.getInt("Enter a number: ");
        long f = factorial(n);

        System.out.printf("%d! = %d%n", n, f);
    }

}
