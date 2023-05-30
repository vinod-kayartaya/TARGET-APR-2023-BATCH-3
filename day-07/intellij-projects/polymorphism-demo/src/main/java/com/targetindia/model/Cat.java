package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Animal {

    public Cat() {
        // the first thing that is executed inside this block is a call to the superclass constructor
        super();
        log.trace("Cat constructor called");
    }

    @Override
    public void talk() {
        log.trace("Cat is meowing...");
    }
}
