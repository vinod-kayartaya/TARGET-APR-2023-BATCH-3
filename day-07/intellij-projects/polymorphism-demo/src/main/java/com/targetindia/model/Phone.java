package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Phone {
    public void dialNumber(){
        log.trace("dialing a number using Phone");
    }

    public void call(){
        log.trace("Calling using Phone");
    }

    public void disconnect(){
        log.trace("Disconnected the call using Phone");
    }
}
