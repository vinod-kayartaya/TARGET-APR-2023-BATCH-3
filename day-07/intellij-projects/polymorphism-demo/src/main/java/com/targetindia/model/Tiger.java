package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tiger extends Animal{

    public Tiger() {
        log.trace("Tiger constructor called");
    }

    public void talk(){
        log.trace("Tiger roaring...");
    }

    public void hunt(){
        log.trace("Tiger is hunting...");
    }
}
