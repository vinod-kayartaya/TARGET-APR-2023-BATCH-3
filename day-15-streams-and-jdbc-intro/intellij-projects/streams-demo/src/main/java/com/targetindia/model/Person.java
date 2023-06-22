package com.targetindia.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private double height;

    public static final List<Person> getMockData(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ezri Haith", 48, 5.9));
        persons.add(new Person("Serena Fritz", 36, 5.9));
        persons.add(new Person("Nikki Seleway", 67, 6.9));
        persons.add(new Person("Ernesto Wheater", 41, 7.0));
        persons.add(new Person("Ethelyn Westlake", 67, 5.1));
        persons.add(new Person("Julio Jurewicz", 44, 6.2));
        persons.add(new Person("Letitia Aldine", 24, 7.0));
        persons.add(new Person("Jae Aldridge", 22, 5.8));
        persons.add(new Person("Frannie Hellwing", 34, 6.8));
        persons.add(new Person("Jackie Hands", 55, 6.5));
        return persons;
    }
}
