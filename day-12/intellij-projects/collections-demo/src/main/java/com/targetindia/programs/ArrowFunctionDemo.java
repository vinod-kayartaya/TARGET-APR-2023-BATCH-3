package com.targetindia.programs;

import com.targetindia.entity.Person;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ArrowFunctionDemo {
    public static void main(String[] args) {
        Comparator<Person> cmp = (p1, p2) -> p1.getName().compareTo(p2.getName());

        Set<Person> persons = new TreeSet<>(cmp);

        persons.add(new Person("Ezri Haith", 48, 5.9));
        persons.add(new Person("Serena Fritz", 36, 5.9));
        persons.add(new Person("Nikki Seleway", 34, 6.9));
        persons.add(new Person("Ernesto Wheater", 41, 7.0));
        persons.add(new Person("Ethelyn Westlake", 44, 5.1));
        persons.add(new Person("Julio Jurewicz", 44, 6.2));
        persons.add(new Person("Letitia Aldine", 24, 7.0));
        persons.add(new Person("Jae Aldridge", 42, 5.8));
        persons.add(new Person("Frannie Hellwing", 34, 6.8));
        persons.add(new Person("Jackie Hands", 55, 6.5));

        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
