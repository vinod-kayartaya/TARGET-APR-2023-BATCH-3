package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsDemo6 {
    public static void main(String[] args) {
        List<Person> persons = Person.getMockData();

        // find all persons who's name starts with letter 'e'
        List<Person> list = persons.stream()
                .filter(p -> p.getName().toLowerCase().startsWith("e"))
                .collect(Collectors.toList());

        list.forEach(System.out::println);

    }
}
