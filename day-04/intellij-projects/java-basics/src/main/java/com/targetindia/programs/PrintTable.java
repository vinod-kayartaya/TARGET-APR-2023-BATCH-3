package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class PrintTable {
    public static void main(String[] args) {
        int num = KeyboardUtil.getInt("Enter a number: ");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", num, i, num * i);
        }
    }
}
