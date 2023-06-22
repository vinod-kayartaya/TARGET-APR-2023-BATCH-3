package com.targetindia.programs;

import java.util.Arrays;
import java.util.List;

public class StreamBasics {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(109, 29, 48, 90, 22, 485, 38, 18, 374, 575, 662);
        System.out.printf("numbers = %s%n", numbers);

        System.out.println("Even numbers: ");
        for (int n : numbers) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }

        System.out.println("Odd numbers: ");
        numbers.stream() // stream of 109, 29, 48, 90, 22, 485, 38, 18, 374, 575, 662
                .filter(n -> n % 2 == 1) // stream of 109, 29, 485, 575
                .forEach(n -> System.out.println(n));

        System.out.print("All numbers: ");
        numbers.forEach(n -> System.out.printf("%d, ", n));
        System.out.println();
    }
}
