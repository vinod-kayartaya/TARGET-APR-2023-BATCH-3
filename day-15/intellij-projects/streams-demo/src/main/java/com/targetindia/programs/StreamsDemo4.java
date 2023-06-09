package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.List;

public class StreamsDemo4 {
    public static void main(String[] args) {
        // select name, height from persons where age>=40 order by height desc
        List<Person> persons = Person.getMockData();

        persons.stream() // from persons
                .filter(p -> p.getAge() >= 40) // where age>=40
                .sorted((p1, p2) -> p2.getHeight() < p1.getHeight() ? -1 : 1) // order by height desc
                .map(p -> new Object[]{p.getName(), p.getHeight()}) // select name
                .forEach(arr -> System.out.printf("%s is %.1f ft tall%n", arr[0], arr[1]));
    }
}
