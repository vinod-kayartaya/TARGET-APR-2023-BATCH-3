package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.Arrays;
import java.util.List;

public class StreamsDemo2 {
    public static void main(String[] args) {
        List<Person> persons = Person.getMockData();

        Object[] names = persons.stream()
                .map(Person::getName) // p->p.getName()
                .toArray();

        System.out.println("names = " + Arrays.toString(names));

        // we can also try to do what we do in SQL
        // SELECT NAME FROM PERSONS WHERE AGE>=40 ORDER BY NAME
        System.out.println("Equivalent of [SELECT NAME FROM PERSONS WHERE AGE>=40 ORDER BY NAME]:");
        persons.stream()
                .filter(person->person.getAge()>=40)
                .map(person->person.getName())
                .sorted()
                .forEach(System.out::println);
    }
}
