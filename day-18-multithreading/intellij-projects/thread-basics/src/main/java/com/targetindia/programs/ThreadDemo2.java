package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo2 {

    public static void main(String[] args) {
        log.trace("start of main()");
        // task to be executed by a thread
        Runnable r1 = () -> {
            for (int i = 1; i <= 15; i++) {
                log.trace("task#1 --> i is {}", i);
            }
        };

        Thread t1 = new Thread(r1, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                log.trace("task#2 --> i is {}", i);
            }
        }, "t2");

        t2.start();
        log.trace("end of main()");
    }
}
