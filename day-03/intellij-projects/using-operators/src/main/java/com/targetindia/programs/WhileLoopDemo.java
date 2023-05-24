package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class WhileLoopDemo {
    public static void main(String[] args) {
        int num = KeyboardUtil.getInteger("Enter a number: ");

        if (num < 1) {
            System.out.println("Please enter a number >= 1");
            return; // skip the rest of main()
        }

        System.out.printf("Fibonacci series until %d%n", num);

        // fibonacci series starts with two numbers 0 and 1
        // the next number is the sum of previous two numbers
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, etc

        int a = -1;
        int b = 1;
        int c;
        while ((c = a + b) < num) {
            System.out.printf("%d, ", c);
            a = b;
            b = c;
        }
    }
}
