package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog extends Animal {

    public Dog() {
        log.trace("Dog constructor called");
    }

    @Override
    public void talk() {
        log.trace("Dog is barking...");
    }
}
