package com.targetindia.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2700, 2713, 1588, 3738, 5516, 660, 660, 9092, 2728, 5123, 6367, 7047);

        List<Integer> evenNumbers = new ArrayList<>();
        for (int i : numbers) {
            if (i % 2 == 0) {
                evenNumbers.add(i);
            }
        }
        System.out.println("even numbers = " + evenNumbers);

        List<Integer> oddNumbers = numbers.stream()            // stream of: 2700, 2713, 1588, 3738, 5516, 660, 660, 9092, 2728, 5123, 6367, 7047
                .filter(n -> n % 2 == 1)  // stream of 2713, 5123, 6367, 7047
                .sorted()
                .collect(Collectors.toList());
        System.out.println("odd numbers = " + oddNumbers);

        numbers.stream()
                .mapToDouble(Math::sqrt)
                .forEach(System.out::println);
                //.collect(Collectors.toList());
    }
}
