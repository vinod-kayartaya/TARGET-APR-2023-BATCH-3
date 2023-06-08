package com.targetindia.programs;

import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        Stream.of(109, 29, 48, 90, 22, 485, 38, 18, 374, 575, 662)// generic stream of integers
                .mapToInt(n -> n) // IntStream
                .max()
                .ifPresent(mi -> System.out.printf("Max int is %d%n", mi));
    }
}
