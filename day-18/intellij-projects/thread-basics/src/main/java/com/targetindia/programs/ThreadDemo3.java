package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class ThreadDemo3 {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                log.trace("i is {}", i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                log.trace("i is {}", i);
            }
        }).start();
        log.trace("thread count = {}", Thread.activeCount());

        for (int i = 1; i <= 15; i++) {
            log.trace("i is {}", i);
        }

    }
}
