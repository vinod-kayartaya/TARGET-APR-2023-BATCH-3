package com.targetindia.programs;

import com.targetindia.entity.Person;

import java.util.HashSet;
import java.util.Set;

public class SetOfPersons {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>(); // uses HashMap (which is type hash-table DS)
        Person p;
        p = new Person("Vinod", 49, 5.8);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p);
        p = new Person("Shyam", 50, 6.2);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p);
        p = new Person("Vinod", 49, 5.8);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p); // dup
        p = new Person("Vinod", 49, 5.8);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p); // dup
        p = new Person("Vinod", 20, 5.9);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p);
        p = new Person("Vinod", 20, 5.2);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p);
        p = new Person("Vinod", 49, 5.8);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p); // dup
        p = new Person("Shyam", 50, 6.2);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p); // dup
        p = new Person("Shyam", 65, 6.0);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p);
        p = new Person("Shyam", 50, 6.2);
        System.out.printf("p=%s, p.hashCode=%d%n", p, p.hashCode());
        people.add(p); // dup

        System.out.printf("There are %d person objects%n", people.size());

        for(Person p1: people){
            System.out.println(p1);
        }
    }
}
