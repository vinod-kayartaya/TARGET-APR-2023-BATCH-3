package com.targetindia.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Employee extends Person {
    // every Employee object has `firstname` and `lastname` inherited from Person class
    // you may not be able to access them here directly, but when memory is allocated for an
    // Employee object, space is reserved for `firstname` and `lastname` along with `id` and `salary`
    private int id;
    private double salary;

    public Employee() {
        log.trace("No-arg Employee() constructor called");
    }

    public Employee(int id, String firstname, String lastname, double salary) {
        super(firstname, lastname);
        log.trace("Employee(id, firstname, lastname, salary) constructor called");
        this.id = id;
        this.salary = salary;
    }
}
