package com.targetindia.programs;

import com.targetindia.model.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonDemo {
    public static void main(String[] args) {
        Person p1; // Person is public, can be accessed anywhere
        p1 = new Person();
        p1.setName("Shyam");
        p1.setEmail("shaym@xmpl.com");
        log.trace("p1 = {}", p1);

        Person p2 = new Person("Vinod", "Bangalore", "vinod@vinod.co");
        log.trace("p2 = {}", p2);

        // log.trace("{} is from {}", p2.name, p2.city); // name and city have private access in Person
        log.trace("{} is from {}", p2.getName(), p2.getCity());
    }
}
