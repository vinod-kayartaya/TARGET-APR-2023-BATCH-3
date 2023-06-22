package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Animal {

    public Animal() {
        // this constructor will be called whenever an object of any of the
        // subclasses for this class is called. For example, Cat, Tiger, Dog etc.,
        log.trace("Animal constructor called");
    }

    // method declaration without body; must be declared as abstract
    public abstract void talk(); // forces the subclasses to override this method with a method body
}
