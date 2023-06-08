package com.targetindia.programs;

import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        String[] names = {
                "Mr.Vinod", "Mr.Harish", "Mr.Shyam", "Ms.Anita", "Ms.Revati", "Mr.Shankar",
                "Mr.Umesh", "Ms.Vani", "Ms.Asha", "Ms.Sujata", "Mr.Kumar"
        };

        System.out.println("Men: ");
        Stream.of(names)
                .filter(StreamDemo3::isMale)
                .forEach(System.out::println);


        System.out.println("Women: ");
        Stream.of(names)
                .filter(StreamDemo3::isFemale)
                .forEach(System.out::println);

        System.out.println("Names in ascending order");
        Stream.of(names)
                .sorted()
                .forEach(System.out::println);

    }

    static boolean isMale(String name) {
        return name.startsWith("Mr.");
    }

    static boolean isFemale(String name) {
        return name.startsWith("Ms.");
    }
}
