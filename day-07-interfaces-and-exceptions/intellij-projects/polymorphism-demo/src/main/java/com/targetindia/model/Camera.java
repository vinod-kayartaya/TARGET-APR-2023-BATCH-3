package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Camera {
    int shutterSpeed = 30; // public, static and final
    void takePicture(); // public and abstract

    // following are allowed only in JDK 1.8+
    default void zoom(){
        throw new RuntimeException("method not implemented yet");
    }

    static void authorInfo(){
        Logger log = LoggerFactory.getLogger(Camera.class);
        log.trace("Vinod Kumar Kayartaya (vinod@vinod.co)");
    }
}
