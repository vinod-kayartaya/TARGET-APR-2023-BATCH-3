package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.List;

public class StreamsDemo5 {
    public static void main(String[] args) {
        // select name, height from persons where age>=40 order by height desc
        List<Person> persons = Person.getMockData();

        persons.stream()
                .max((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)
                .ifPresent(System.out::println);


    }
}
