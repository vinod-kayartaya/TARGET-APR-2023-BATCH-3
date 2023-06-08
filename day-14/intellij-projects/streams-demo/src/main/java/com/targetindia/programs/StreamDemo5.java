package com.targetindia.programs;

import java.util.stream.Stream;

public class StreamDemo5 {
    public static void main(String[] args) {
        String[] names = {
                "Mr.Vinod", "Mr.Harish", "Mr.Shyam", "Ms.Anita", "Ms.Revati", "Mr.Shankar",
                "Mr.Umesh", "Ms.Vani", "Ms.Asha", "Ms.Sujata", "Mr.Kumar"
        };

        System.out.println("Names with out title in ascending order");
        Stream.of(names) // names with title (Mr. or Ms.)
                .map(name -> name.substring(3)) // names without title
                .sorted() // sorted names
                .forEach(System.out::println); // void

        System.out.println("Numbers divided by 10 in ascending order");
        Stream.of(109, 29, 48, 90, 22, 485, 38, 18, 374, 575, 662)
                .filter(n -> n > 100) // stream of 109, 485, 374, 575, 662
                .mapToDouble(n -> n / 10.)
                .sorted()
                .forEach(System.out::println);
    }
}
