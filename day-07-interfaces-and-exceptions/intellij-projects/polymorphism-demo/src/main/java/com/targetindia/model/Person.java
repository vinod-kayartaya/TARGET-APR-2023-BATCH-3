package com.targetindia.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Person {
    private String firstname;
    private String lastname;

    public Person() {
        log.trace("No-arg Person() constructor called");
    }

    public Person(String firstname, String lastname) {
        log.trace("Person(firstname, lastname) constructor called");
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
