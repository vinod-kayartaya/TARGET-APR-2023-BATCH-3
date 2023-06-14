package com.targetindia.threads;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GreetingThread extends Thread{
    @Override
    @SneakyThrows
    public void run() {
        log.trace("Start of run() in GreetingThread");

        for(int k=100; k<115; k++){
            log.trace("value of k in GreetingThread.run() is {}", k);
            Thread.sleep(100);
        }

        log.trace("End of run() in GreetingThread");
    }
}
