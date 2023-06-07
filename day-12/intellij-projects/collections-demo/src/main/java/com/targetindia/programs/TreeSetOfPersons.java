package com.targetindia.programs;

import com.targetindia.entity.Person;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetOfPersons {

    static class PersonAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            // System.out.printf("comparing %s with %s%n", p1, p2);
            int result = Double.compare(p2.getHeight(), p1.getHeight());
            if (result != 0) return result;

            result = p2.getAge() - p1.getAge();
            if (result != 0) return result;

            result = p1.getName().compareTo(p2.getName());
            return result;
        }
    }

    public static void main(String[] args) {

        // cmp knows how to compare two Person objects
        Comparator<Person> cmp = new PersonAgeComparator();

        Set<Person> persons = new TreeSet<>(cmp);
        // Person is not Comparable, but it is okay, since the TreeSet has cmp, which knows
        // how to compare two Person objects
        persons.add(new Person("Ezri Haith", 36, 5.9));
        persons.add(new Person("Serena Fritz", 36, 5.9));
        persons.add(new Person("Nikki Seleway", 34, 6.9));
        persons.add(new Person("Frannie Hellwing", 34, 6.8));
        persons.add(new Person("Frannie Hellwing", 34, 6.8));
        persons.add(new Person("Frannie Hellwing", 34, 6.8));
        persons.add(new Person("Ernesto Wheater", 41, 7.0));
        persons.add(new Person("Ethelyn Westlake", 44, 5.1));
        persons.add(new Person("Julio Jurewicz", 44, 6.2));
        persons.add(new Person("Ethelyn Westlake", 44, 5.1));
        persons.add(new Person("Ethelyn Westlake", 44, 5.2));
        persons.add(new Person("Ethelyn Westlake", 44, 5.1));
        persons.add(new Person("Ethelyn Westlake", 44, 5.4));
        persons.add(new Person("Letitia Aldine", 24, 7.0));
        persons.add(new Person("Jae Aldridge", 42, 5.8));
        persons.add(new Person("Ethelyn Westlake", 44, 5.1));
        persons.add(new Person("Frannie Hellwing", 34, 6.8));
        persons.add(new Person("Jackie Hands", 55, 6.5));

        for (Person p : persons) {
            System.out.println(p);
        }


    }
}
