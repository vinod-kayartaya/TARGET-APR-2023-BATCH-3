package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmartPhone extends Phone implements Camera{
    @Override
    public void takePicture(){
        log.trace("Taking a picture using SmartPhone");
    }

    @Override
    public void zoom() {
        log.trace("zooming from 0x to 10x");
    }
}
